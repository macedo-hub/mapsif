package br.com.example.mapsif.model;

public class Sala {
    private String id;
    private String titulo;
    private String subtitulo;
    private String descricao;
    private int icone;
    private int imagem;
    private boolean temTransito;
    private Localizacao localizacao;

    //construtor
    public Sala(String id, String titulo, String subtitulo, String descricao, int icone, int imagem, boolean temTransito, Localizacao localizacao) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descricao = descricao;
        this.icone = icone;
        this.imagem = imagem;
        this.temTransito = temTransito;
        this.localizacao = localizacao;
    }

    //get
    public String getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getSubtitulo() {
        return subtitulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getIcone() {
        return icone;
    }
    public int getImagem() {
        return imagem;
    }
    public boolean isTemTransito() {
        return temTransito;
    }
    public Localizacao getLocalizacao() {
        return localizacao;
    }
}
