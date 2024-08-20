package com.samsung.phanvantiendung.repositories;

import com.samsung.phanvantiendung.repositories.models.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
