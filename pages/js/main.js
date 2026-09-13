/* ==========================================================================
   MapsIF — main.js
   Nenhuma dependência de build: JS puro, roda direto no navegador.
   ========================================================================== */

(function () {
  "use strict";

  var reduzMovimento = window.matchMedia("(prefers-reduced-motion: reduce)").matches;
  var raizHtml = document.documentElement;

  /* ------------------------------------------------------------------
     Ícones (Lucide) — precisa rodar antes de qualquer coisa que
     dependa dos ícones já estarem no DOM.
  ------------------------------------------------------------------ */
  if (window.lucide) {
    window.lucide.createIcons();
  }

  /* ------------------------------------------------------------------
     Modo escuro / claro — padrão é claro; só muda se a pessoa
     já tiver escolhido antes (guardado no localStorage).
  ------------------------------------------------------------------ */
  var CHAVE_TEMA = "mapsif-tema";
  var botaoTema = document.querySelector("[data-botao-tema]");

  function aplicarTema(tema) {
    if (tema === "escuro") {
      raizHtml.setAttribute("data-tema", "escuro");
    } else {
      raizHtml.removeAttribute("data-tema");
    }
  }

  var temaSalvo = null;
  try {
    temaSalvo = localStorage.getItem(CHAVE_TEMA);
  } catch (erro) {
    /* localStorage indisponível (modo privado, etc.) — segue no tema claro padrão */
  }
  if (temaSalvo) aplicarTema(temaSalvo);

  if (botaoTema) {
    botaoTema.addEventListener("click", function () {
      var atual = raizHtml.getAttribute("data-tema") === "escuro" ? "escuro" : "claro";
      var proximo = atual === "escuro" ? "claro" : "escuro";
      aplicarTema(proximo);
      try {
        localStorage.setItem(CHAVE_TEMA, proximo);
      } catch (erro) {
        /* segue sem salvar */
      }
    });
  }

  /* ------------------------------------------------------------------
     Cabeçalho com fundo ao rolar + menu móvel
  ------------------------------------------------------------------ */
  var cabecalho = document.querySelector(".cabecalho");
  var botaoMenu = document.querySelector("[data-botao-menu]");
  var menuMovel = document.querySelector("[data-menu-movel]");

  function aoRolar() {
    if (!cabecalho) return;
    if (window.scrollY > 12) {
      cabecalho.classList.add("tem-fundo");
    } else {
      cabecalho.classList.remove("tem-fundo");
    }
  }
  window.addEventListener("scroll", aoRolar, { passive: true });
  aoRolar();

  if (botaoMenu && menuMovel) {
    botaoMenu.addEventListener("click", function () {
      var aberto = menuMovel.classList.toggle("aberto");
      botaoMenu.setAttribute("aria-expanded", aberto ? "true" : "false");
    });
    menuMovel.querySelectorAll("a").forEach(function (link) {
      link.addEventListener("click", function () {
        menuMovel.classList.remove("aberto");
        botaoMenu.setAttribute("aria-expanded", "false");
      });
    });
  }

  /* ------------------------------------------------------------------
     Sequência de entrada do hero (uma única vez, ao carregar)
  ------------------------------------------------------------------ */
  window.requestAnimationFrame(function () {
    setTimeout(function () {
      document.body.classList.add("carregada");
    }, reduzMovimento ? 0 : 120);
  });

  /* ------------------------------------------------------------------
     Mostrador de rotação — gira conforme a rolagem da página,
     como se a página fosse uma volta de 360°.
  ------------------------------------------------------------------ */
  var agulha = document.querySelector("[data-agulha]");
  var leituraGrau = document.querySelector("[data-leitura-grau]");

  function atualizarMostrador() {
    if (!agulha) return;
    var alturaTotal = document.documentElement.scrollHeight - window.innerHeight;
    var progresso = alturaTotal > 0 ? window.scrollY / alturaTotal : 0;
    var graus = Math.round(progresso * 360);
    agulha.style.transform = "rotate(" + graus + "deg)";
    if (leituraGrau) leituraGrau.textContent = String(graus).padStart(3, "0") + "°";
  }
  window.addEventListener("scroll", atualizarMostrador, { passive: true });
  window.addEventListener("resize", atualizarMostrador);
  atualizarMostrador();

  /* ------------------------------------------------------------------
     Diretório do campus — acordeão por andar
  ------------------------------------------------------------------ */
  document.querySelectorAll("[data-andar-cabecalho]").forEach(function (botao) {
    botao.addEventListener("click", function () {
      var andar = botao.closest(".andar");
      if (!andar) return;
      var estavaAberto = andar.classList.contains("aberto");
      andar.classList.toggle("aberto", !estavaAberto);
      botao.setAttribute("aria-expanded", (!estavaAberto).toString());
    });
  });

  /* ------------------------------------------------------------------
     Ano no rodapé
  ------------------------------------------------------------------ */
  var elementoAno = document.querySelector("[data-ano-atual]");
  if (elementoAno) elementoAno.textContent = String(new Date().getFullYear());

  /* ------------------------------------------------------------------
     Visualizador 360 (Pannellum) — só existe na home.
     Uma única cena de EXEMPLO, sem navegação entre ambientes.
     Troque a imagem em pages/img/pannellum/panorama-exemplo.jpg pela foto real.
  ------------------------------------------------------------------ */
  var elementoVisualizador = document.getElementById("visualizador-360");
  var moldura = document.querySelector(".moldura-panorama__quadro");

  if (elementoVisualizador && window.location.protocol === "file:") {
    /* Pannellum carrega a imagem via requisição, e o navegador bloqueia esse
       tipo de requisição quando a página é aberta direto do arquivo (file://).
       Por isso o aviso "The file [...] could not be accessed." aparece.
       Solução: servir a pasta por um servidor local, ex.:
         python3 -m http.server 8000     (depois abrir http://localhost:8000)
       ou a extensão "Live Server" do VS Code / editor equivalente. */
    elementoVisualizador.innerHTML =
      '<div class="aviso-panorama">' +
      '<strong>Prévia 360° indisponível aqui.</strong>' +
      '<p>Abrindo o arquivo direto (file://), o navegador bloqueia o carregamento da imagem do Pannellum. ' +
      'Rode um servidor local — por exemplo <code>python3 -m http.server</code> na pasta do site — e abra pelo endereço ' +
      '<code>http://localhost</code> em vez do arquivo.</p></div>';
    if (moldura) moldura.classList.add("moldura-panorama__quadro--aviso");
    var primeiraLegenda = document.querySelector(".legenda-panorama span:first-child");
    if (primeiraLegenda) primeiraLegenda.textContent = "Prévia 360°";
  } else if (elementoVisualizador && window.pannellum) {
    window.pannellum.viewer("visualizador-360", {
      type: "equirectangular",
      panorama: "pages/img/pannellum/panorama-exemplo.jpg",
      autoLoad: true,
      compass: false
    });
  }
})();
