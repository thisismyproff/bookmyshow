package com.mayur.bookmyshow.repositories;

import com.mayur.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    List<ShowSeat> findAllById(List<Long> ids);
}
