package com.latidude99.links.repository;

import com.latidude99.links.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface H2LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findById(Long id);

    Optional<Link> findByIdAndExpiryDays(Long id, int expiryDays);

    Optional<Link> findByIdAndPin(Long id, String pin);

    Optional<Link> findByPin(String pin);

    List<Optional<Link>> findAllByDeleted(boolean flag);

    List<Link> getAllByDeleted(boolean flag);

    Link save(Link link);
}
