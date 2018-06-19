package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.InvestmentsDao;
import com.javaj2eefsd.workshop.model.Investments;

/**
 * @author Nagarjuna - InvestmentsService interface used to validate the business logic and help to call the dao layer
 */
@Service
public class InvestmentsServiceImpl implements InvestmentsService {
	
	@Autowired
	InvestmentsDao investmentsDaoImpl;
	
	/**
     * getInvestmentsAll method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
	@Override
    public List<Investments> getInvestmentsAll(String userId) throws Exception {
		return investmentsDaoImpl.getInvestmentsAll("1");
    }

    /**
     * createInvestments method used to create new Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
    @Override
    public Investments createInvestments(Investments investmentsObj) throws Exception {
    	investmentsObj.setCreatedDate(OffsetDateTime.now());
    	investmentsObj.setUpdatedDate(OffsetDateTime.now());
    	investmentsObj.setCreatedBy("1");
    	investmentsObj.setUpdatedBy(investmentsObj.getCreatedBy());
    	investmentsObj.setIsDelete(false);
        return investmentsDaoImpl.createInvestments(investmentsObj);
    }

    /**
     * deleteInvestments method used to delete the Investments data based on user input
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
    @Override
    public void deleteInvestments(String investmentsId) throws Exception {
    	investmentsDaoImpl.deleteInvestments(investmentsId);
    }

    /**
     * updateInvestments method used to update the Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
    @Override
    public Investments updateInvestments(Investments investmentsObj) throws Exception {
    	investmentsObj.setUpdatedDate(OffsetDateTime.now());
    	investmentsObj.setCreatedBy("1");
        return investmentsDaoImpl.updateInvestments(investmentsObj);
    }

    /**
     * searchInvestments method used to search the Investments data based on user inputs
     *
     * @param InvestmentsKey
     * @return
     * @throws Exception
     */
    @Override
    public List<Investments> searchInvestments(String investmentsKey) throws Exception {
    	return investmentsDaoImpl.searchInvestments(investmentsKey);
    }
}
