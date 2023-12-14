package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.RefundDTO;
import com.gestion_tiendas_nosql.Exceptions.RefundNotFoundException;
import com.gestion_tiendas_nosql.Entities.Refund;
import com.gestion_tiendas_nosql.Repositories.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefundService {

    @Autowired
    private RefundRepository refundRepository;

    public List<Refund> getRefunds(){ return refundRepository.findAll(); }

    public Refund getRefundById(String id){
        Optional<Refund> refund = refundRepository.findById(id);
        if(refund.isPresent()){
            return refund.get();
        }else {
            throw new RefundNotFoundException(id);
        }
    }

    public Refund createRefund(RefundDTO refundDTO){
        Refund refund = Refund
                .builder()
                .causeOfReturn(refundDTO.getCauseOfReturn())
                .client(refundDTO.getClient())
                .date(refundDTO.getDate())
                .order(refundDTO.getOrder())
                .returnedProducts(refundDTO.getReturnedProducts())
                .build();
        return refundRepository.save(refund);
    }

    public Refund updateRefund(String id, RefundDTO refundDTO){
        Optional<Refund> refund = refundRepository.findById(id);
        if(refund.isPresent()){
            Refund existingRefund = refund.get();
            existingRefund.setDate(refundDTO.getDate());
            existingRefund.setOrder(refundDTO.getOrder());
            existingRefund.setCauseOfReturn(refundDTO.getCauseOfReturn());
            existingRefund.setReturnedProducts(refundDTO.getReturnedProducts());
            existingRefund.setClient(refundDTO.getClient());
            return refundRepository.save(existingRefund);
        }else{
            throw new RefundNotFoundException(id);
        }
    }

    public boolean deleteRefund(String id){
        if(refundRepository.existsById(id)){
            refundRepository.deleteById(id);
            return true;
        }else{
            throw new RefundNotFoundException(id);
        }
    }
}
