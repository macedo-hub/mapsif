/* Barra lateral: os nomes das seções sobem de baixo até o topo conforme a página rola */
function indicador(ids){
 var H=document.documentElement,ind=document.getElementById("ind");if(!ind)return;
 var els=ids.map(function(x){return document.getElementById(x)}),ils=[].slice.call(ind.querySelectorAll("a.il")),ps=document.getElementById("ps"),pc=document.getElementById("pc"),tops=[];
 function medir(){tops=els.map(function(e){return e.getBoundingClientRect().top+scrollY})}
 function cl(v){return Math.max(0,Math.min(1,v))}
 function ez(v){return 1-Math.pow(1-v,3)}
 function rolar(){var m=H.scrollHeight-innerHeight,pr=m?scrollY/m:0,h=ind.clientHeight,vh=innerHeight,N=ils.length,q=tops.map(function(t){return ez(cl((vh-(t-scrollY))/(vh-140)))});
  q[N-1]=Math.max(q[N-1],ez(cl((pr-.94)/.06)));
  ps.style.top=(pr*(h-4))+"px";pc.textContent=Math.round(pr*100)+"%";
  ils.forEach(function(a,i){var out=i<N-1?q[i+1]:0,yb=h-44-(N-1-i)*28,y=yb+(14-yb)*q[i]-out*60;
   a.style.transform="translateY("+y.toFixed(1)+"px) scale("+(.62+.38*q[i]).toFixed(3)+")";a.style.opacity=((.5+.5*q[i])*(1-out)).toFixed(3);a.classList.toggle("on",q[i]>.6&&out<.5)})}
 medir();addEventListener("resize",function(){medir();rolar()});addEventListener("load",function(){medir();rolar()});
 addEventListener("scroll",rolar,{passive:true});rolar();
}
