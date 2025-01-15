package TP3.TP3.controller;

import TP3.TP3.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressesController {
    @Autowired
    AddressRepository addressRepository;
    @GetMapping("/addresses")
    public String showForm(Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll());
        return "html/addresses";
    }
}