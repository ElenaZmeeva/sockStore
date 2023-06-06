package com.example.sockstore.repository;
import com.example.sockstore.SocksEnum;
import com.example.sockstore.entity.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {

    int countSocksByCottonPartLessThan(int cottonPart);

    int countSocksByCottonPartGreaterThan(int cottonPart);

    int countSocksByCottonPartEquals(int cottonPart);

    List<Socks> findAll();

    Optional<Socks>findByColorAndCottonPart(String color, int cottonPart);

    @Query(value = "SELECT SUM(quantity) FROM socks", nativeQuery = true)
    Integer countSocks(SocksEnum socksEnum);
}

