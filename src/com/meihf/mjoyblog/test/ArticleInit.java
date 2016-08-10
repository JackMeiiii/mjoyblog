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
 * @desc:添加文章到数据库
 * @author 梅海风
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
		System.out.println(articleDao.queryList(new Query().addCriteria(Criteria.where("catalogId").is("你好明天"))).size());
	}
	private void init() {
		mongoTemplate.dropCollection(Article.class);
		
		Article art2 = new Article();
		art2.setArticleContent("信用度-历史欠费-当前欠费  用户催停阀值——配置用户催缴、呼限、停机阀值 }你快乐吗？我很快乐业务及使用场景说明实时信控，就是系统根据信控告警工单(billing侧触发)，实时地对预付费帐户/用户进行信控规则的校验，并执行相应信控动作。 实时信控的主要对象是预付费帐户/用户。为保证信控动作能够及时正确的执行，系统中任何影响到帐户/用户可用资金变化的动作，如按帐户/用户缴费、缴费返销、帐户资金转移、退预存、调帐等等，都需要触发信控告警。此外实时}");
		art2.setArticleId("001");
		art2.setArticlePath("FaceBook");
		art2.setArticleTitle("你快乐吗？我很快乐");
		art2.setCatalogId("hello明天");
		art2.setLimit((short) 1);
		art2.setScanNumber(333l);
		art2.setWriteDate(DateUtil.getCurrDate());
		
		Article art1 = new Article();
		art1.setArticleContent("信用度-历史欠费-当前欠费  用户催停阀值——配置用户催缴、呼限、停机阀值 }你快乐吗？我很快乐业务及使用场景说明实时信控，就是系统根据信控告警工单(billing侧触发)，实时地对预付费帐户/用户进行信控规则的校验，并执行相应信控动作。 实时信控的主要对象是预付费帐户/用户。为保证信控动作能够及时正确的执行，系统中任何影响到帐户/用户可用资金变化的动作，如按帐户/用户缴费、缴费返销、帐户资金转移、退预存、调帐等等，都需要触发信控告警。此外实时}");
		art1.setArticleId("002");
		art1.setArticlePath("FaceBook");
		art1.setArticleTitle("你快乐吗？我很快乐");
		art1.setCatalogId("hello今天");
		art1.setLimit((short) 1);
		art1.setScanNumber(333l);
		art1.setWriteDate(DateUtil.getCurrDate());
		
		Article art4 = new Article();
		art4.setArticleContent("信用度-历史欠费-当前欠费  用户催停阀值——配置用户催缴、呼限、停机阀值 }你快乐吗？我很快乐业务及使用场景说明实时信控，就是系统根据信控告警工单(billing侧触发)，实时地对预付费帐户/用户进行信控规则的校验，并执行相应信控动作。 实时信控的主要对象是预付费帐户/用户。为保证信控动作能够及时正确的执行，系统中任何影响到帐户/用户可用资金变化的动作，如按帐户/用户缴费、缴费返销、帐户资金转移、退预存、调帐等等，都需要触发信控告警。此外实时}");
		art4.setArticleId("003");
		art4.setArticlePath("FaceBook");
		art4.setArticleTitle("你快乐吗？我很快乐");
		art4.setCatalogId("hello后天");
		art4.setLimit((short) 1);
		art4.setScanNumber(333l);
		art4.setWriteDate(DateUtil.getCurrDate());
		
		Article art5 = new Article();
		art5.setArticleContent("信用度-历史欠费-当前欠费  用户催停阀值——配置用户催缴、呼限、停机阀值 }你快乐吗？我很快乐业务及使用场景说明实时信控，就是系统根据信控告警工单(billing侧触发)，实时地对预付费帐户/用户进行信控规则的校验，并执行相应信控动作。 实时信控的主要对象是预付费帐户/用户。为保证信控动作能够及时正确的执行，系统中任何影响到帐户/用户可用资金变化的动作，如按帐户/用户缴费、缴费返销、帐户资金转移、退预存、调帐等等，都需要触发信控告警。此外实时}");
		art5.setArticleId("004");
		art5.setArticlePath("FaceBook");
		art5.setArticleTitle("你快乐吗？我很快乐");
		art5.setCatalogId("你好明天");
		art5.setLimit((short) 1);
		art5.setScanNumber(333l);
		art5.setWriteDate(DateUtil.getCurrDate());
		
		Article art6 = new Article();
		art6.setArticleContent("信用度-历史欠费-当前欠费  用户催停阀值——配置用户催缴、呼限、停机阀值 }你快乐吗？我很快乐业务及使用场景说明实时信控，就是系统根据信控告警工单(billing侧触发)，实时地对预付费帐户/用户进行信控规则的校验，并执行相应信控动作。 实时信控的主要对象是预付费帐户/用户。为保证信控动作能够及时正确的执行，系统中任何影响到帐户/用户可用资金变化的动作，如按帐户/用户缴费、缴费返销、帐户资金转移、退预存、调帐等等，都需要触发信控告警。此外实时}");
		art6.setArticleId("005");
		art6.setArticlePath("FaceBook");
		art6.setArticleTitle("你快乐吗？我很快乐");
		art6.setCatalogId("你好今天");
		art6.setLimit((short) 1);
		art6.setScanNumber(333l);
		art6.setWriteDate(DateUtil.getCurrDate());
		
		Article art3 = new Article();
		art3.setArticleContent("业务及使用场景说明实时信控，就是系统根据信控告警工单(billing侧触发)，实时地对预付费帐户/用户进行信控规则的校验，并执行相应信控动作。 实时信控的主要对象是预付费帐户/用户。为保证信控动作能够及时正确的执行，系统中任何影响到帐户/用");
		art3.setArticleId("006");
		art3.setArticlePath("path");
		art3.setArticleTitle("今天你吃了吗？");
		art3.setCatalogId("你好后天");
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
