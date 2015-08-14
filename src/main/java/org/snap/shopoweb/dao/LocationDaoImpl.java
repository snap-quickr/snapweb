/*
 *  @version     1.0, 14-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.snap.shopoweb.beans.*;

public class LocationDaoImpl implements LocationDao {
    
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Location> getAllLocations(){
        String sql = "select * from location";
        List<Location> locations = jdbcTemplate.query(sql, new LocationMapper());
        return locations;
    }

}
