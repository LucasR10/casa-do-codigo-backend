package br.com.casacodigo.api.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Lucas Carvalho
 * @since 10/09/200
 * 
 *        É necessário cadastrar um novo autor no sistema. Todo autor tem um
 *        nome, email e uma descrição. Também queremos saber o instante exato
 *        que ele foi registrado.
 * 
 */

@Entity
@Table(name = "autor", schema = "cadastro_base")
public class Autor implements Serializable {

    @Id
    @SequenceGenerator(name = "autor_seq_name", sequenceName = "autor_sequence", schema = "cadastro_base")
    @GeneratedValue(generator = "autor_seq_name")
    @Column(name = "codigo", nullable = false, insertable = false, unique = true, updatable = false)
    private BigInteger codigo;

    @Column(name = "nome", nullable = false, updatable = true)
    @NotNull
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 400)
    @NotNull
    private String email;

    @Column(name = "descricao", nullable = false, insertable = true)
    @NotNull
    private String descricao;

    @Column(name = "dt_cadastro", nullable = false, insertable = true)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCadastro;

    public Autor() {
    }

    public Autor(BigInteger codigo, String nome, String email, String descricao, Calendar dataCadastro) {
	this.codigo = codigo;
	this.nome = nome;
	this.email = email;
	this.descricao = descricao;
	this.dataCadastro = dataCadastro;
    }

    public BigInteger getCodigo() {
	return codigo;
    }

    public void setCodigo(BigInteger codigo) {
	this.codigo = codigo;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Calendar getDataCadastro() {
	return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
	this.dataCadastro = dataCadastro;
    }

}
