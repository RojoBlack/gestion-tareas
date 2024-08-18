package com.tareas.gestiontareas.repository;

import com.tareas.gestiontareas.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByEstado(Tarea.Estado estado);

    List<Tarea> findByCategoriaNombre(String nombreCategoria);

    List<Tarea> findAllByOrderByFechaVencimientoAsc();

}