package main.java.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.mvc.controller.ControleCadastroFornecedor;

public class FormCadastroFornecedor {
    
    public static void main(String[] args) {
        
        String nomeFantasia;
        String razaoSocial;
        String cnpj;
        
        List<String> cnaes = new ArrayList<String>();
        
        String inscricaoEstadual;
        String inscricaoMunicipal;
        String email;
        
        List<String> nomeContatos = new ArrayList<String>();
        List<String> dptoContatos = new ArrayList<String>();
        List<String> emailContatos = new ArrayList<String>();
        List<String> dddTelefoneContatos = new ArrayList<String>();
        List<String> ddiTelefoneContatos = new ArrayList<String>();
        List<String> numeroTelefoneContatos = new ArrayList<String>();
        
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
        String status;
        
        char outroCnae = 'n';
        char outroContato = 'n';

        Scanner sc = new Scanner(System.in);

        System.out.println("Cadastro de Fornecedores ===");
        
        System.out.print("Entre com os dados do fornecedor: ");
        
        System.out.print("Nome Fantasia: ");
        nomeFantasia = sc.nextLine();
        
        System.out.print("Razao Social: ");
        razaoSocial = sc.nextLine();
        
        System.out.print("cnpj: ");
        cnpj = sc.nextLine();
        
        /*System.out.print("cnae: ");
        cnae = sc.nextLine();*/
        
        do {
            System.out.print("cnae: ");
            cnaes.add(sc.nextLine());
            
            System.out.print("Outro CNAE? (s/n): ");
            outroCnae = sc.nextLine().charAt(0);
            System.out.println();
        } while (outroCnae == 's');
        
        System.out.print("insc Estadual: ");
        inscricaoEstadual = sc.nextLine();
        
        System.out.print("Insc Municipal: ");
        inscricaoMunicipal = sc.nextLine();
        
        System.out.print("email: ");
        email = sc.nextLine();
        
        /*System.out.print("ddd Telefone: ");
        dddTelefone = sc.nextLine();
        
        System.out.print("ddi Telefone: ");
        ddiTelefone = sc.nextLine();
        
        System.out.print("numero Telefone: ");
        numeroTelefone = sc.nextLine();
        
        System.out.print("ramal Telefone: ");
        ramalTelefone = sc.nextLine();*/
        

        
        /*System.out.print("nome Contato: ");
        nomeContato = sc.nextLine();
        
        System.out.print("dpto Contato: ");
        dptoContato = sc.nextLine();
        
        System.out.print("email Contato: ");
        emailContato = sc.nextLine();
        
        System.out.print("ddd Telefone Contato: ");
        dddTelefoneContato = sc.nextLine();
        
        System.out.print("ddi Telefone Contato: ");
        ddiTelefoneContato = sc.nextLine();
        
        System.out.print("numero Telefone Contato: ");
        numeroTelefoneContato = sc.nextLine();
        
        System.out.print("ramal Telefone Contato: ");
        ramalTelefoneContato = sc.nextLine();*/
        
        do {
        	System.out.print("nome Contato: ");
            nomeContatos.add(sc.nextLine());
    
            System.out.print("dpto Contato: ");
            dptoContatos.add(sc.nextLine());
    
            System.out.print("email Contato: ");
            emailContatos.add(sc.nextLine());
    
            System.out.print("ddd Telefone Contato: ");
            dddTelefoneContatos.add(sc.nextLine());
    
            System.out.print("ddi Telefone Contato: ");
            ddiTelefoneContatos.add(sc.nextLine());
    
            System.out.print("numero Telefone Contato: ");
            numeroTelefoneContatos.add(sc.nextLine());
            
            System.out.print("Deseja adicionar outro contato? (s/n): ");
            outroContato = sc.nextLine().charAt(0);
            System.out.println();
        } while (outroContato == 's');
        
        System.out.print("Tipo Endereco: ");
        tipoEndereco = sc.nextLine();
        
        System.out.print("cep Endereco: ");
        cepEndereco = sc.nextLine();
        
        System.out.print("Tipo logradouro Endereco: ");
        tipoLogradouroEndereco = sc.nextLine();
        
        System.out.print("Logradouro Endereco: ");
        logradouroEndereco = sc.nextLine();
        
        System.out.print("Nummero Endereco: ");
        numeroEndereco = sc.nextLine();
        
        System.out.print("Complemento Endereco: ");
        complementoEndereco = sc.nextLine();
        
        System.out.print("Bairro Endereco: ");
        bairroEndereco = sc.nextLine();
        
        System.out.print("Cidade Endereco: ");
        cidadeEndereco = sc.nextLine();
        
        System.out.print("UF Endereco: ");
        ufEndereco = sc.nextLine();
        
        System.out.print("Pais Endereco: ");
        paisEndereco = sc.nextLine();
        
        System.out.print("Status: ");
        status = sc.nextLine();


        ControleCadastroFornecedor.salvarFornecedor(nomeFantasia, razaoSocial, cnpj, inscricaoEstadual, inscricaoMunicipal, email, tipoEndereco, cepEndereco, 
                tipoLogradouroEndereco, logradouroEndereco, numeroEndereco, bairroEndereco, complementoEndereco, cidadeEndereco, ufEndereco, paisEndereco, cnaes,
                nomeContatos, dptoContatos, emailContatos, dddTelefoneContatos, ddiTelefoneContatos, numeroTelefoneContatos, status
        		);
    	}
    
    

}
