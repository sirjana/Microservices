package com.example.addressservice.repository;

import com.example.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query(
            nativeQuery = true,
            value
                    = """
                      select a.* from address a inner join employee e on a.emp_id = e. id
                                                          where e.id = :employeeId""")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);


//    @Query("SELECT ea.id, ea.city, ea.state FROM Address ea JOIN Employee e ON e.id = ea.employee.id WHERE ea.employee.id = :employeeId")
//    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}

