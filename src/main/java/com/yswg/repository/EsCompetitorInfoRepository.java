package com.yswg.repository;

import com.yswg.entity.es.EsCompetitorInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EsCompetitorInfoRepository extends ElasticsearchRepository<EsCompetitorInfo, Integer> {
}
