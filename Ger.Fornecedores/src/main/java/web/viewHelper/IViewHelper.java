package web.viewHelper;

import core.aplicacao.Resultado;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dominio.EntidadeDominio;
import java.io.IOException;


public interface IViewHelper {

    public EntidadeDominio getEntidade(HttpServletRequest request);

    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
