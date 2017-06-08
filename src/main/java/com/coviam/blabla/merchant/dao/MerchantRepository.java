package com.coviam.blabla.merchant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.blabla.merchant.entity.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,Integer> {
}