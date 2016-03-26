package com.routefinder.repository;

import com.routefinder.model.FavoriteRoute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */
public interface FavoriteRouteRepository extends JpaRepository<FavoriteRoute, Integer> {
}