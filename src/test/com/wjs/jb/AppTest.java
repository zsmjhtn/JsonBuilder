package test.com.wjs.jb;


import junit.framework.TestCase;
import main.com.wjs.jb.FastJsonJB;
import main.com.wjs.jb.GsonJB;
import main.com.wjs.jb.JsonJB;
import main.com.wjs.jb.imp.JB;
import main.com.wjs.jb.imp.JBEntry;
import test.com.wjs.jb.testbean.Product;
import test.com.wjs.jb.testbean.ProductExtra;
import test.com.wjs.jb.testbean.ProductPromotionPolicy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/6
 */
public class AppTest extends TestCase {

    private final void log(Object value) {
        Throwable throwable = new Throwable();
        StackTraceElement stackTraceElement = throwable.getStackTrace()[1];
        System.out.println("------" + stackTraceElement.getMethodName() + "------");
        System.out.println(value);
        System.out.println();
    }

    public void testEmptyObject() {
        JB jb = new GsonJB();
        //@formatter:off
        jb.o()
        .eo();
        //@formatter:on

        log(jb);
    }

    public void testObject() {
        JB jb = new GsonJB();
        //@formatter:off
        jb.o()
        .k("name").v("lingoes")
		.k("age").v(18)
        .k("contact")
           .o()
                .k("tel").v("0571-88888888")
                .k("QQ").v("3141592653")
				.k("wechat").v("lingoes")
           .eo()
        .eo();
        //@formatter:on

        log(jb);
    }

    public void testEmptyArray() {
        final JB jb = new GsonJB();
        //@formatter:off
		jb.a()
		.ea();
		//@formatter:on

        log(jb);
    }

    public void testArray() {
        final JB jb = new GsonJB();
        //@formatter:off
		jb.a()
			.v(1)
			.v(2)
			.v(3)
                .o()
                .k("111").v("222")
                .eo()
			.a()
				.v(1)
				.v(4)
				.v(9)
			.ea()
		.ea();
		//@formatter:on

        log(jb);
    }

    public void testObjectIf() throws ParseException {
        Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-11"), 120,4);

        final JB jb = new GsonJB();
        //@formatter:off
		jb.o()
			.k("productName").v(product.getProductName())
			.k("placeOfOrigin").v(product.getPlaceOfOrigin())
			.if_(product.getExpirationDate().before(new Date()))
				.k("expirationDate").v("Out Of Date")
                .if_(product.getCode() == 1)
                    .k("code").v("1")
                .elseif(product.getCode() == 2)
                    .k("code").v("2")
                .elseif(product.getCode() == 3)
                    .k("code").v("3")
                .else_()
                    .k("code").v("none")
                .eif()
			.else_()
				.k("expirationDate").v(product.getExpirationDate())
			.eif()
            .if_(true)
                 .k("obj")
                 .o()
                     .if_(true)
                     .k("obj1").v(new String[]{"2-","3!","4$"})
                     .k("obj2").v(new Integer[]{6,7,8,9})
                     .else_()
                     .k("obj3").v("131314!@@#")
                     .eif()
                 .eo()
            .eif()
			.k("price").v(product.getPrice())
		.eo();
		//@formatter:on

        log(jb);
    }

    public void testKeyIf() throws ParseException {
        Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-11"), 120, 3);

        final JB jb = new GsonJB();
        //@formatter:off
		jb.o()
			.k("productName").v(product.getProductName())
			.k("placeOfOrigin").v(product.getPlaceOfOrigin())
			.k("expirationDate").if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
			.else_()
				.v(product.getExpirationDate())
			.eif()
			.k("price").v(product.getPrice())
		.eo();
		//@formatter:on

        log(jb);
    }

	public void testEhanceElse() throws ParseException {
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-11"), 120, 3);

		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("productName").v(product.getProductName())
			.k("expirationDate").if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
			.else_()
				.o()
				.parse(product)
				.eo()
			.eif()
			.k("price").v(product.getPrice())
		.eo();
		//@formatter:on

		log(jb);
	}

    public void testArrayIf() throws ParseException {
        Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-11"), 120, 4);

        final JB jb = new GsonJB();
        //@formatter:off
		jb.a()
			.v(product.getProductName())
			.v(product.getPlaceOfOrigin())
			.if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
            .elseif(true)
                .v("zsmjhtn")
			.else_()
				.v(product.getExpirationDate())
			.eif()
            .if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
            .else_()
                .o()
                .k("gmail").v("zsmjhtn")
                .eo()
			.eif()
            .if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
            .elseif(true)
                .a()
                .v("qqmail")
                .ea()
			.eif()
		.ea();
		//@formatter:on

        log(jb);
    }

    public void testObjectFor() {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        final JB jb = new FastJsonJB();
        //@formatter:off
		jb.o()
			.k("square-table").o()
				.for_(array)
					.it((i, v)->{ return new JBEntry(v+"*"+v,v*v);})
				.efor()
			.eo()
		.eo();
		//@formatter:on

        log(jb);
    }

    public void testArrayFor() {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        final JB jb = new GsonJB();
        //@formatter:off
		jb.o()
			.k("square-list").a()
				.for_(array)
					.it((v)->{return v*v;})
				.efor()
				.for_(array)
					.it()
				.efor()
			.ea()
		.eo();
		//@formatter:on

        log(jb);
    }

	public void testObjectParse() throws ParseException {
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"), 120, 3);
		ProductExtra productExtra = new ProductExtra("online");
		ProductPromotionPolicy promotionPolicy = new ProductPromotionPolicy("满100减30");

		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.parse(product)
			.parse(productExtra)
			.parse(promotionPolicy)
		.eo();
		//@formatter:on

		log(jb);
	}

	public void testArrayParse() throws ParseException {
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"), 120,1);
		ProductExtra productExtra = new ProductExtra("taobao");
		ProductPromotionPolicy promotionPolicy0 = new ProductPromotionPolicy("满100减30");
		ProductPromotionPolicy promotionPolicy1 = new ProductPromotionPolicy("满300减100");
		ProductPromotionPolicy promotionPolicy2 = new ProductPromotionPolicy("满500减200");

		final JB jb = new JsonJB();
		//@formatter:off
		jb.o()
			.parse(product)
			.parse(productExtra)
			.k("promotionPolicy").a()
				.parse(promotionPolicy0, promotionPolicy1, promotionPolicy2)
			.ea()
		.eo();
		//@formatter:on

		log(jb);
	}
}
