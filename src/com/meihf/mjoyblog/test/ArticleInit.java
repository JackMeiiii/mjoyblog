package com.meihf.mjoyblog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.meihf.mjoyblog.bean.Article;
import com.meihf.mjoyblog.dao.ArticleDao;
import com.meihf.mjoyblog.util.DateUtil;

/**
 * @desc:������µ����ݿ�
 * @author ÷����
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class ArticleInit {

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Test
	public void test(){
		this.init();
		System.out.println(articleDao.queryList(new Query().addCriteria(Criteria.where("catalogId").is("�������"))).size());
	}
	private void init() {
		mongoTemplate.dropCollection(Article.class);
		
		Article art2 = new Article();
		art2.setArticleContent("���ö�-��ʷǷ��-��ǰǷ��  �û���ͣ��ֵ���������û��߽ɡ����ޡ�ͣ����ֵ }��������Һܿ���ҵ��ʹ�ó���˵��ʵʱ�ſأ�����ϵͳ�����ſظ澯����(billing�ഥ��)��ʵʱ�ض�Ԥ�����ʻ�/�û������ſع����У�飬��ִ����Ӧ�ſض����� ʵʱ�ſص���Ҫ������Ԥ�����ʻ�/�û���Ϊ��֤�ſض����ܹ���ʱ��ȷ��ִ�У�ϵͳ���κ�Ӱ�쵽�ʻ�/�û������ʽ�仯�Ķ������簴�ʻ�/�û��ɷѡ��ɷѷ������ʻ��ʽ�ת�ơ���Ԥ�桢���ʵȵȣ�����Ҫ�����ſظ澯������ʵʱ}");
		art2.setArticleId("001");
		art2.setArticlePath("FaceBook");
		art2.setArticleTitle("��������Һܿ���");
		art2.setCatalogId("hello����");
		art2.setLimit((short) 1);
		art2.setScanNumber(333l);
		art2.setWriteDate(DateUtil.getCurrDate());
		
		Article art1 = new Article();
		art1.setArticleContent("���ö�-��ʷǷ��-��ǰǷ��  �û���ͣ��ֵ���������û��߽ɡ����ޡ�ͣ����ֵ }��������Һܿ���ҵ��ʹ�ó���˵��ʵʱ�ſأ�����ϵͳ�����ſظ澯����(billing�ഥ��)��ʵʱ�ض�Ԥ�����ʻ�/�û������ſع����У�飬��ִ����Ӧ�ſض����� ʵʱ�ſص���Ҫ������Ԥ�����ʻ�/�û���Ϊ��֤�ſض����ܹ���ʱ��ȷ��ִ�У�ϵͳ���κ�Ӱ�쵽�ʻ�/�û������ʽ�仯�Ķ������簴�ʻ�/�û��ɷѡ��ɷѷ������ʻ��ʽ�ת�ơ���Ԥ�桢���ʵȵȣ�����Ҫ�����ſظ澯������ʵʱ}");
		art1.setArticleId("002");
		art1.setArticlePath("FaceBook");
		art1.setArticleTitle("��������Һܿ���");
		art1.setCatalogId("hello����");
		art1.setLimit((short) 1);
		art1.setScanNumber(333l);
		art1.setWriteDate(DateUtil.getCurrDate());
		
		Article art4 = new Article();
		art4.setArticleContent("���ö�-��ʷǷ��-��ǰǷ��  �û���ͣ��ֵ���������û��߽ɡ����ޡ�ͣ����ֵ }��������Һܿ���ҵ��ʹ�ó���˵��ʵʱ�ſأ�����ϵͳ�����ſظ澯����(billing�ഥ��)��ʵʱ�ض�Ԥ�����ʻ�/�û������ſع����У�飬��ִ����Ӧ�ſض����� ʵʱ�ſص���Ҫ������Ԥ�����ʻ�/�û���Ϊ��֤�ſض����ܹ���ʱ��ȷ��ִ�У�ϵͳ���κ�Ӱ�쵽�ʻ�/�û������ʽ�仯�Ķ������簴�ʻ�/�û��ɷѡ��ɷѷ������ʻ��ʽ�ת�ơ���Ԥ�桢���ʵȵȣ�����Ҫ�����ſظ澯������ʵʱ}");
		art4.setArticleId("003");
		art4.setArticlePath("FaceBook");
		art4.setArticleTitle("��������Һܿ���");
		art4.setCatalogId("hello����");
		art4.setLimit((short) 1);
		art4.setScanNumber(333l);
		art4.setWriteDate(DateUtil.getCurrDate());
		
		Article art5 = new Article();
		art5.setArticleContent("���ö�-��ʷǷ��-��ǰǷ��  �û���ͣ��ֵ���������û��߽ɡ����ޡ�ͣ����ֵ }��������Һܿ���ҵ��ʹ�ó���˵��ʵʱ�ſأ�����ϵͳ�����ſظ澯����(billing�ഥ��)��ʵʱ�ض�Ԥ�����ʻ�/�û������ſع����У�飬��ִ����Ӧ�ſض����� ʵʱ�ſص���Ҫ������Ԥ�����ʻ�/�û���Ϊ��֤�ſض����ܹ���ʱ��ȷ��ִ�У�ϵͳ���κ�Ӱ�쵽�ʻ�/�û������ʽ�仯�Ķ������簴�ʻ�/�û��ɷѡ��ɷѷ������ʻ��ʽ�ת�ơ���Ԥ�桢���ʵȵȣ�����Ҫ�����ſظ澯������ʵʱ}");
		art5.setArticleId("004");
		art5.setArticlePath("FaceBook");
		art5.setArticleTitle("��������Һܿ���");
		art5.setCatalogId("�������");
		art5.setLimit((short) 1);
		art5.setScanNumber(333l);
		art5.setWriteDate(DateUtil.getCurrDate());
		
		Article art6 = new Article();
		art6.setArticleContent("���ö�-��ʷǷ��-��ǰǷ��  �û���ͣ��ֵ���������û��߽ɡ����ޡ�ͣ����ֵ }��������Һܿ���ҵ��ʹ�ó���˵��ʵʱ�ſأ�����ϵͳ�����ſظ澯����(billing�ഥ��)��ʵʱ�ض�Ԥ�����ʻ�/�û������ſع����У�飬��ִ����Ӧ�ſض����� ʵʱ�ſص���Ҫ������Ԥ�����ʻ�/�û���Ϊ��֤�ſض����ܹ���ʱ��ȷ��ִ�У�ϵͳ���κ�Ӱ�쵽�ʻ�/�û������ʽ�仯�Ķ������簴�ʻ�/�û��ɷѡ��ɷѷ������ʻ��ʽ�ת�ơ���Ԥ�桢���ʵȵȣ�����Ҫ�����ſظ澯������ʵʱ}");
		art6.setArticleId("005");
		art6.setArticlePath("FaceBook");
		art6.setArticleTitle("��������Һܿ���");
		art6.setCatalogId("��ý���");
		art6.setLimit((short) 1);
		art6.setScanNumber(333l);
		art6.setWriteDate(DateUtil.getCurrDate());
		
		Article art3 = new Article();
		art3.setArticleContent("ҵ��ʹ�ó���˵��ʵʱ�ſأ�����ϵͳ�����ſظ澯����(billing�ഥ��)��ʵʱ�ض�Ԥ�����ʻ�/�û������ſع����У�飬��ִ����Ӧ�ſض����� ʵʱ�ſص���Ҫ������Ԥ�����ʻ�/�û���Ϊ��֤�ſض����ܹ���ʱ��ȷ��ִ�У�ϵͳ���κ�Ӱ�쵽�ʻ�/��");
		art3.setArticleId("006");
		art3.setArticlePath("path");
		art3.setArticleTitle("�����������");
		art3.setCatalogId("��ú���");
		art3.setLimit((short) 0);
		art3.setScanNumber(111l);
		art3.setWriteDate(DateUtil.getCurrDate());
		
		articleDao.save(art2);
		articleDao.save(art3);
		articleDao.save(art4);
		articleDao.save(art5);
		articleDao.save(art6);
		articleDao.save(art1);
	}
	
}
