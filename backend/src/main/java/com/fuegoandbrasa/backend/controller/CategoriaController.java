package com.fuegoandbrasa.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fuegoandbrasa.backend.model.Categoria;
import com.fuegoandbrasa.backend.service.CategoriaService;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable Long id){ // @PathVariable sirve para extraer valores directamente de la URL de una petición HTTP y pasarlos como parámetros al método en el controlador.
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @PostMapping
    public Categoria crearCategoira(@RequestBody Categoria categoria){
        return categoriaService.guardarCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizarCategoria (@PathVariable Long id, @RequestBody Categoria categoriaActualizada){
        return categoriaService.actualizarCategoria(id, categoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Long id){
        categoriaService.eliminarCategoria(id);
    }
    
}
