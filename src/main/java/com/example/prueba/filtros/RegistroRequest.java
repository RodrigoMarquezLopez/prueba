package com.example.prueba.filtros;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
// Registro en consola
public class RegistroRequest extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info(String.format("\nSolicitud recibida: IP=%s Ruta=%s Fecha y hora=%s%n",
                request.getRemoteAddr(), request.getRequestURI(), LocalDateTime.now()));
        filterChain.doFilter(request, response);

    }
}
