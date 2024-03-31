package com.example.StructurHome.repository.jdbc.impl;

import com.example.StructurHome.Model.Entity.Home;
import com.example.StructurHome.repository.jdbc.HomeJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

@Repository
@RequiredArgsConstructor//Jdbc islemir
public class HomeJdbcRepositoryImpl implements HomeJdbcRepository {
        private final JdbcTemplate jdbcTemplate;
    @Override
        public List<Home> getAll() {
            String query = "SELECT h.number, h.area, h.repaircondition, h.floor, h.type, h.place, h.roominformation FROM home_sales.home h;";

            RowMapper<Home> rowMapper = new RowMapper<>() {
                @Override
                public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return buildHome(rs);
                }
            };

            return jdbcTemplate.query(query, rowMapper);
        }

        @Override
        public Home getByNumber(Long number) {
            String query = "SELECT h.number, h.area, h.repaircondition, h.floor, h.type, h.place, h.roominformation FROM home_sales.home h WHERE h.number = ?";


            RowMapper<Home> rowMapper = new RowMapper<Home>() {
                @Override
                public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return buildHome(rs);
                }
            };

            List<Home> homes = jdbcTemplate.query(query, rowMapper, number);

            if (homes.isEmpty()) {
                return Home.builder()
                        .build();
            }

            return homes.get(0);
        }


        @Override
        public boolean insert(Home home)  {
            String query = "INSERT INTO home_sales.home (area, repaircondition, floor, type, place, roominformation) VALUES (?, ?, ?, ?, ?, ?);";

            int res = jdbcTemplate.update(query, home.getArea(), home.getRepaircondition(), home.getFloor(), home.getType(), home.getPlace(), home.getRoominformation());

            return res != 0;
        }

        @Override
        public boolean update(Home home) {
            String query = "UPDATE home_sales.home h SET h.area = ?, h.repaircondition = ?, h.floor = ?, h.type = ?, h.place = ?, h.roominformation = ? WHERE h.number = ?";

            int res = jdbcTemplate.update(query, home.getArea(), home.getRepaircondition(), home.getFloor(), home.getType(), home.getPlace(), home.getRoominformation(), home.getNumber());

            return res != 0;
        }

        @Override
        public boolean updateFloor(Long number, Integer floor) {
            String query = "UPDATE home_sales.home h SET h.floor = ? WHERE h.number = ?";

            int res = jdbcTemplate.update(query, floor, number);

            return res != 0;
        }

        @Override
        public boolean delete(Long number) {
            String query = "DELETE FROM home_sales.home h WHERE h.number = ?;";

            int res = jdbcTemplate.update(query, number);

            return res != 0;
        }

        private Home buildHome(ResultSet rs) throws SQLException {
            return Home.builder()
                    .number(rs.getLong("number"))
                    .area(rs.getString("area"))
                    .repaircondition(rs.getString("repaircondition"))
                    .floor(rs.getInt("floor"))
                    .type(rs.getString("type"))
                    .place(rs.getString("place"))
                    .roominformation(rs.getString("roominformation"))
                    .build();
        }
    }
