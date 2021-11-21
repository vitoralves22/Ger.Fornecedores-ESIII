package main.java.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.mvc.controller.Controle;

public class FormFornecedor {
    
    public static void main(String[] args) {
        
        String nomeFantasia;
        String razaoSocial;
        String cnpj;  
        String inscricaoEstadual;
        String inscricaoMunicipal;
        String email;
        
        List<String> cnaes = new ArrayList<String>();    
        List<String> ddiTelefones = new ArrayList<String>();
        List<String> dddTelefones = new ArrayList<String>();
        List<String> numeroTelefones = new ArrayList<String>();
        List<String> nomeContatos = new ArrayList<String>();
        List<String> dptoContatos = new ArrayList<String>();
        List<String> emailContatos = new ArrayList<String>();
        List<String> dddTelefoneContatos = new ArrayList<String>();
        List<String> ddiTelefoneContatos = new ArrayList<String>();
        List<String> numeroTelefoneContatos = new ArrayList<String>();
        List<String> produtos = new ArrayList<String>();
        List<String> servicos = new ArrayList<String>();
        List<String> tipoEmpresas = new ArrayList<String>();
        List<String> tipoFornecimentos = new ArrayList<String>();
        
        String tipoEndereco;
        String cepEndereco;
        String tipoLogradouroEndereco;
        String logradouroEndereco;
        String numeroEndereco;
        String complementoEndereco;
        String bairroEndereco;
        String cidadeEndereco;
        String ufEndereco;
        String paisEndereco;
        String produto;
        String servico;
   
        char outroCnae = 'n';
        char outroTelefone = 'n';
        char outroContato = 'n';
        char outroProduto = 'n';
        char outroServico = 'n';
        char outraEmpresa = 'n';

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cadastro de Fornecedores ===\n");
        
        System.out.print("Entre com os dados do fornecedor: \n");
        
        System.out.print("Nome Fantasia: ");
        nomeFantasia = sc.nextLine();
        
        System.out.print("Razao Social: ");
        razaoSocial = sc.nextLine();
        
        System.out.print("CNPJ: ");
        cnpj = sc.nextLine();
        
        do {
            System.out.print("CNAE: ");
            cnaes.add(sc.nextLine());
            
            System.out.print("Outro CNAE? (s/n): ");
            outroCnae = sc.nextLine().charAt(0);
            System.out.println();
        } while (outroCnae == 's');
        
        System.out.print("Inscricao Estadual: ");
        inscricaoEstadual = sc.nextLine();
        
        System.out.print("Inscricao Municipal: ");
        inscricaoMunicipal = sc.nextLine();
        
        System.out.print("Email: ");
        email = sc.nextLine();
        
        do {
            System.out.println();
            
            System.out.print("Digite o DDI: ");
            ddiTelefones.add(sc.nextLine());

            System.out.print("Digite o DDD: ");
            dddTelefones.add(sc.nextLine());

            System.out.print("Digite o Número: ");
            numeroTelefones.add(sc.nextLine());
            System.out.println();

            System.out.print("Deseja adicionar outro Telefone? (s/n): ");
            outroTelefone = sc.nextLine().charAt(0);
        } while (outroTelefone == 's');
        System.out.println();
        
        do {
        	System.out.print("Nome Contato: ");
            nomeContatos.add(sc.nextLine());
    
            System.out.print("Departamento: ");
            dptoContatos.add(sc.nextLine());
    
            System.out.print("Email: ");
            emailContatos.add(sc.nextLine());
    
            System.out.print("DDD: ");
            dddTelefoneContatos.add(sc.nextLine());
    
            System.out.print("DDI: ");
            ddiTelefoneContatos.add(sc.nextLine());
    
            System.out.print("Numero telefone: ");
            numeroTelefoneContatos.add(sc.nextLine());
            
            System.out.print("Deseja adicionar outro contato? (s/n): ");
            outroContato = sc.nextLine().charAt(0);
            System.out.println();
        } while (outroContato == 's');
        
        System.out.print("Tipo Endereco: ");
        tipoEndereco = sc.nextLine();
        
        System.out.print("CEP: ");
        cepEndereco = sc.nextLine();
        
        System.out.print("Tipo logradouro: ");
        tipoLogradouroEndereco = sc.nextLine();
        
        System.out.print("Logradouro: ");
        logradouroEndereco = sc.nextLine();
        
        System.out.print("Numero: ");
        numeroEndereco = sc.nextLine();
        
        System.out.print("Complemento: ");
        complementoEndereco = sc.nextLine();
        
        System.out.print("Bairro: ");
        bairroEndereco = sc.nextLine();
        
        System.out.print("Cidade: ");
        cidadeEndereco = sc.nextLine();
        
        System.out.print("UF: ");
        ufEndereco = sc.nextLine();
        
        System.out.print("Pais: ");
        paisEndereco = sc.nextLine();
        
        
        do {
            System.out.print("Tipo Empresa: ");
            tipoEmpresas.add(sc.nextLine());
            
            System.out.print("Tipo Fornecimento: ");
            tipoFornecimentos.add(sc.nextLine());

            System.out.print("Deseja adicionar outra Empresa? (s/n): ");
            outroProduto = sc.nextLine().charAt(0);
        } while (outraEmpresa == 's');
        System.out.println();
        
        do {
            System.out.print("Produto: ");
            produtos.add(sc.nextLine());

            System.out.print("Deseja adicionar outro Produto? (s/n): ");
            outroProduto = sc.nextLine().charAt(0);
        } while (outroProduto == 's');
        System.out.println();
        
        do {           
            System.out.print("Servico: ");
            servicos.add(sc.nextLine());

            System.out.print("Deseja adicionar outro Servico? (s/n): ");
            outroServico = sc.nextLine().charAt(0);
        } while (outroServico == 's');
        System.out.println();


        Controle.salvarFornecedor(nomeFantasia, razaoSocial, cnpj, inscricaoEstadual, inscricaoMunicipal, email, tipoEndereco, cepEndereco, 
                tipoLogradouroEndereco, logradouroEndereco, numeroEndereco, bairroEndereco, complementoEndereco, cidadeEndereco, ufEndereco, paisEndereco, cnaes,
                nomeContatos, dptoContatos, emailContatos, dddTelefoneContatos, ddiTelefoneContatos, numeroTelefoneContatos,
                dddTelefones, ddiTelefones, numeroTelefones, produtos, servicos, tipoEmpresas, tipoFornecimentos
        		);
    	}
    
    

}
