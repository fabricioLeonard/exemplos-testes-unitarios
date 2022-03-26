package br.com.developeracademy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverUmaPessoaInexistente(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        //Execução
        cadastro.remove(pessoa);
    }

    @Test
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

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarUmaPessoaSemNome(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        //Execução
        cadastro.adicionar(pessoa);
    }

    @Test
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
    public void deveCriarOCadastroDePessoasVazio(){
        //Cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();
        //Verificação
        Assertions
                .assertThat(cadastro.getPessoas())
                .isEmpty();
    }
}
