package com.example.prueba.filtros;

import com.example.prueba.peticion.Peticion;
import com.example.prueba.peticion.PeticionService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class FiltroTiempo extends OncePerRequestFilter {

    private final LocalTime inicio = LocalTime.of(9, 0);
    private final LocalTime fin = LocalTime.of(18, 0);
    private final PeticionService peticionService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        log.info(String.format("\nSolicitud recibida: IP=%s Ruta=%s Fecha y hora=%s%n",
                request.getRemoteAddr(), request.getRequestURI(), LocalDateTime.now()));

        peticionService.insrtertar(Peticion.builder().ip(request.getRemoteAddr()).build());
        LocalTime ahora = LocalTime.now();
        DayOfWeek hoy = LocalDate.now().getDayOfWeek();
        if (hoy == DayOfWeek.SATURDAY || hoy == DayOfWeek.SUNDAY ||
                ahora.isBefore(inicio) || ahora.isAfter(fin)) {

            response.setStatus(HttpServletResponse.SC_CONFLICT);
            response.getWriter().write("Acceso denegado: Fuera del horario permitido.");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
