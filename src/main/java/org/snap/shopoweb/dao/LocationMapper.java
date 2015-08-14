/*
 *  @version     1.0, 14-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.snap.shopoweb.beans.Location;
import org.springframework.jdbc.core.RowMapper;

public class LocationMapper implements RowMapper<Location> {
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();              
        location.setLocationId(rs.getInt("locationId"));
        location.setLocationName(rs.getString("locationName"));
        return location;
    }
}
