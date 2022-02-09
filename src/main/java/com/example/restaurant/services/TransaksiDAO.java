package com.example.restaurant.services;

import com.example.restaurant.model.TransaksiMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class TransaksiDAO {

    @Autowired
    private EntityManager em;

    public List<TransaksiMapping> tryNative(String namaPembeli){
        String nativeQueryScript = "SELECT RAND(100) AS id, pb.username, mn.makanan, mn.minuman, rd.username FROM pembeli pb \n"+
                "LEFT JOIN menu mn ON pb.menu_id = mn.id \n" +
                "INNER JOIN rider rd ON rd.menu_id = mn.id WHERE pb.username = :namaPembeli";
        Query q = em.createNativeQuery(nativeQueryScript, "cobaNative");

        List<TransaksiMapping> list = q.setParameter("namaPembeli",namaPembeli).getResultList();

        return list;
    }
}
