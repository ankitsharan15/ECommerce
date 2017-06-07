package com.coviam.blabla.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.blabla.entity.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,Long> {
}