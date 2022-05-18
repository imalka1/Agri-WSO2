package lk.agri.controller;

import lk.agri.entity.Item;
import lk.agri.entity.Cart;
import lk.agri.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "agriculture/" + "farmer")
public class FarmerController {

    @Autowired
    private FarmerService itemService;

    @PostMapping(value = "/addItem")
    public ResponseEntity addItem(@RequestPart("item") Item item, @RequestParam(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.ok(itemService.addItem(item, file));
    }

    @PostMapping(value = "/addCart")
    public ResponseEntity addCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(itemService.addCart(cart));
    }

    @GetMapping(value = "/getAllCards/{nic}")
    public ResponseEntity getAlCards(@PathVariable String nic) {
        return ResponseEntity.ok(itemService.getAllCards(nic));
    }

    @GetMapping(value = "/getAllCarts/{nic}")
    public ResponseEntity getAllCarts(@PathVariable String nic) {
        return ResponseEntity.ok(itemService.getAllCarts(nic));
    }

    @GetMapping(value = "/AllCards")
    public ResponseEntity AllCards() {
        return ResponseEntity.ok(itemService.AllCards());
    }

    @GetMapping(value = "/card/{getByName}")
    public ResponseEntity getCardsByTitle(@PathVariable String getByName) {
        return ResponseEntity.ok(itemService.getCardsByTitle(getByName));
    }

    @PutMapping(value = "/updateCard/{id}")
    public ResponseEntity updateItem(@PathVariable String id, @RequestBody Item item) {
        return ResponseEntity.ok(itemService.updateItem(id, item));
    }

    @DeleteMapping(value = "/deleteCart/{nic}/{itemID}")
    public ResponseEntity deleteCart(@PathVariable String nic, @PathVariable String itemID) {
        return ResponseEntity.ok(itemService.deleteCart(nic, itemID));
    }

}
