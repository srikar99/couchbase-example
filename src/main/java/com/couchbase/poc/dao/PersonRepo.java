package com.couchbase.poc.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;

@Repository
public class PersonRepo {

	public List<Map<String, Object>> getPersonList() {
		Cluster cluster = CouchbaseCluster.create("couchbase://127.0.0.1");
		Bucket bucket = cluster.openBucket("bucketName", "bucket");

		JsonObject jsonObj = JsonObject.create();
		jsonObj.put("id", 2).put("name", "fourthperson").put("email", "fourth@test.com");
		JsonDocument document = JsonDocument.create("id", jsonObj);
		
		bucket.upsert(document);

		N1qlQuery query = N1qlQuery.simple("select * from bucketName where id IS NOT MISSING");
		
		N1qlQueryResult result = bucket.query(query);
		
		return result.allRows().stream().map(i -> i.value().toMap()).collect(Collectors.toList());
	}
}
