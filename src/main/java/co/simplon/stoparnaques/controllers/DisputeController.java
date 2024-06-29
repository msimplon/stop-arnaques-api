package co.simplon.stoparnaques.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stoparnaques.dtos.DisputeView;
import co.simplon.stoparnaques.services.DisputeService;

@CrossOrigin
@RestController
@RequestMapping("/disputes")
public class DisputeController {

    private final DisputeService service;

    public DisputeController(DisputeService service) {
	this.service = service;
    }

    @GetMapping
    public List<DisputeView> findAll() {
	return service.findAll();
    }
}
