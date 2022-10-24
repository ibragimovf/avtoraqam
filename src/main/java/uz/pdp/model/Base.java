package uz.pdp.model;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public interface Base {
    void get(ResultSet resultSet);
}
