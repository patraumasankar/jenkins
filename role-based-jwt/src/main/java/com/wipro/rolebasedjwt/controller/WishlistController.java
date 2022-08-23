package com.wipro.rolebasedjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rolebasedjwt.model.DAOUser;
import com.wipro.rolebasedjwt.model.Product;
import com.wipro.rolebasedjwt.model.Wishlist;
import com.wipro.rolebasedjwt.service.CustomUserDetailsService;
import com.wipro.rolebasedjwt.service.ProductService;
import com.wipro.rolebasedjwt.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin
public class WishlistController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private WishlistService wishlistService;

	@Autowired
	private ProductService productService;

	@GetMapping("/list/{username}")
	public Page<Wishlist> getWishList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,@PathVariable String username) {

		PageRequest request = PageRequest.of(page - 1, size);
		Page<Wishlist> wishListPage;
		DAOUser user = customUserDetailsService.getUser(username);
		wishListPage = wishlistService.findByBuyerEmail(user.getId(), request);

		return wishListPage;
	}

	@PostMapping("/add/{productId}/{username}")
	public ResponseEntity<Wishlist> addWishList(@PathVariable long productId,@PathVariable String username) {

		Product product = productService.getProductById(productId);
		DAOUser user = customUserDetailsService.getUser(username);
		Wishlist wishList = new Wishlist(user, product);
		Wishlist wishListCreated = wishlistService.createWishlist(wishList);
		return new ResponseEntity<Wishlist>(wishListCreated, HttpStatus.CREATED);

	}
}
