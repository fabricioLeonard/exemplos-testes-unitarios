package br.com.developer;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve lançar um erro ao tentar remover uma pessoa inexistente.")
    public void deveLancarErroAoTentarRemoverUmaPessoaInexistente(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class,
                () -> cadastro.remove(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa.")
    public void deveRemoverUmaPessoa(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fabrício Leonard");
        cadastro.adicionar(pessoa);
        //Execução
        cadastro.remove(pessoa);
        //Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();;
    }

    @Test
    @DisplayName("Não deve adicionar uma pessoa sem nome.")
    public void naoDeveAdicionarUmaPessoaSemNome(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                PessoaSemNomeException.class,
                () -> cadastro.adicionar(pessoa));
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa.")
    public void deveAdicionarUmaPessoa(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fabrício Leonard");
        //Execução
        cadastro.adicionar(pessoa);
        //Verificação
        Assertions
                .assertThat(cadastro.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }
    @Test
    @DisplayName("Deve criar o cadastro de pessoas vazio.")
    public void deveCriarOCadastroDePessoasVazio(){
        //Cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();
        //Verificação
        Assertions
                .assertThat(cadastro.getPessoas())
                .isEmpty();
    }
}
