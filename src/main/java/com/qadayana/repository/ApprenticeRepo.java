package com.qadayana.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.qadayana.entity.Apprentice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApprenticeRepo {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Apprentice save(Apprentice apprentice) {
        dynamoDBMapper.save(apprentice);
        return apprentice;
    }

    public Apprentice getApprenticeById(String apprenticeId) {
        return dynamoDBMapper.load(Apprentice.class, apprenticeId);
    }

    public String delete(String apprenticeId) {
        Apprentice app = dynamoDBMapper.load(Apprentice.class, apprenticeId);
        dynamoDBMapper.delete(app);
        return "Apprentice Deleted.";
    }

    public String update(String apprenticeId, Apprentice apprentice) {
        dynamoDBMapper.save(apprentice,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("apprenticeId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(apprenticeId)
                                )));
        return apprenticeId;
    }
}
