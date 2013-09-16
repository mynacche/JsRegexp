package cn.mynacche.test;

import org.junit.Test;

import cn.mynacche.regexp.JsRegExp;
import cn.mynacche.regexp.Rpl;

/**
 * @author mynacche
 * @date 2013-9-16
 */
public class JunitTest {

	@Test
	public void t_replaceFirst1() {

		String target = "hello world, hello world, hello world";

		target = JsRegExp.replaceFirst(target, "hello\\W+world", new Rpl() {

			public String fn(String... $) {

				return $[0].toUpperCase();
			}

		});
		System.out.println(target);
	}
	@Test
	public void t_replaceFirst2() {

		String target = "hello world, hello world, hello world";

		target = JsRegExp.replaceFirst(target, "hello\\W+world","$0".toUpperCase()); //don't work
		target = JsRegExp.replaceFirst(target, "hello\\W+world","[$0]");
		System.out.println(target);
	}
	@Test
	public void t_replaceLast() {

		String target = "hello world, hello world, hello world";

		target = JsRegExp.replaceLast(target, "hello\\W+world", new Rpl() {

			public String fn(String... $) {

				return $[0].toUpperCase();
			}

		});
		System.out.println(target);
	}
	@Test
	public void t_replaceLast2() {

		String target = "hello world, hello world, hello world";

		target = JsRegExp.replaceLast(target, "hello\\W+world", "你好,世界");
		System.out.println(target);
	}
	@Test
	public void t_replaceAll1() {

		String target = "outOfMemory";

		target = JsRegExp.replaceAll(target, "[A-Z]", new Rpl() {

			public String fn(String... $) {

				return "_" + $[0].toLowerCase();
			}

		});
		System.out.println(target);
	}

	@Test
	public void t_replaceAll2() {

		String target = "outOfMemory";

		target = JsRegExp.replaceAll(target, "[A-Z]","_$0");
		System.out.println(target);
	}
	@Test
	public void t_replaceAll3() {

		String target = "out_of_memory";

		target = JsRegExp.replaceAll(target, "_[a-zA-Z]", new Rpl() {

			public String fn(String... $) {

				return $[0].substring(1).toUpperCase();
			}

		});
		System.out.println(target);
	}
	
	

	@Test
	public void t_replaceAll4() {

		String target = "hello, world";

		target = JsRegExp.replaceAll(target, "(hello)\\W+(world)", new Rpl() {

			public String fn(String... $) {

				return $[2] + ", " + $[1];
			}

		});
		System.out.println(target);
	}
	@Test
	public void t_replaceAll5() {

		String target = "hello, world";

		target = JsRegExp.replaceAll(target, "(hello)\\W+(world)","$2, $1");
		System.out.println(target);
	}
	@Test
	public void t_html() {

		String target = "<img src=\"http://localhost/images/logo.png\" height=\"200\" width=\"100\">\n"
				+ "<IMG src=\"http://localhost/images/logo.png\" height=\"256\" width=\"128\">";
		String regexp = "(?ims)<img\\s+src\\s*=\\s*\"(\\S+)\"\\s+height\\s*=\\s*\"(\\S+)\"\\s+width\\s*=\\s*\"(\\S+)\"\\s*>";
		System.out.println(target);
		System.out.println(regexp);
		target = JsRegExp.replaceAll(target, regexp, new Rpl() {

			public String fn(String... $) {

				return "<img src=\"" + $[1] + "?heigth=" + $[2] + "&width=" + $[3] + "\" height=\""
						+ $[2] + "\" width=\"" + $[3] + "\">";
			}

		});
		System.out.println(target);
	}
}
