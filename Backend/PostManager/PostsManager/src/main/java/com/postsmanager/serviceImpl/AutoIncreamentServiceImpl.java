package com.postsmanager.serviceImpl;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.postsmanager.model.Index;
import com.postsmanager.service.AutoIncreamentService;

@Service
public class AutoIncreamentServiceImpl implements AutoIncreamentService{

	private MongoOperations mongoOperations;
	
	
	public AutoIncreamentServiceImpl(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}


	@Override
	public int generateSequence(String seqName) {
		// TODO Auto-generated method stub
		Index counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("index",1), options().returnNew(true).upsert(true),
                Index.class);
        return !Objects.isNull(counter) ? counter.getIndex() : 1;
	}

}
