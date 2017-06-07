package com.coviam.blabla.merchant.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coviam.blabla.merchant.entity.Score;
import com.coviam.blabla.merchant.entity.ScoreId;

@Repository
public interface ScoreRepository extends CrudRepository<Score,ScoreId>{
}