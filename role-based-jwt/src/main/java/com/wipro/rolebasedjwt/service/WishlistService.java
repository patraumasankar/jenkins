package com.wipro.rolebasedjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wipro.rolebasedjwt.model.Wishlist;
import com.wipro.rolebasedjwt.repository.WishlistRepository;

@Service
public class WishlistService {
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	 public Wishlist createWishlist(Wishlist wishList) {
	    	return wishlistRepository.save(wishList);
	    }
	 
	 public Page<Wishlist> findByBuyerEmail(Long id, PageRequest request) {
			return wishlistRepository.findAllByUserId(id, request);
		}
	 
}
