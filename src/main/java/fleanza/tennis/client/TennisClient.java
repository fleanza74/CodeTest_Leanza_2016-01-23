package fleanza.tennis.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import fleanza.tennis.impl.PreloadRally;
import fleanza.tennis.impl.RandomRally;
import fleanza.tennis.impl.Single;
import fleanza.tennis.spec.Game;
import fleanza.tennis.spec.Rally;

/**
 * @author fleanza
 */
public class TennisClient {

	private static final String header = "Tennis\n\n";
	private static final String footer = "\nPlease report issues at https://github.com/fleanza74/CodeTest_Leanza_2016-01-23/issues/new\n";

	private static final String STATEGY_RANDOM = "R";
	private static final String STATEGY_PRELOAD = "P";

	private static Options options;

	public TennisClient() {
	}

	private static Options options() {
		if(options == null) {
			synchronized(TennisClient.class) {
				if(options == null) {
					Option i = Option.builder("p1").required().hasArg().argName("player1").desc("The player 1 name").build();
					Option o = Option.builder("p2").required().hasArg().argName("player2").desc("The player 1 name").build();
					Option s = Option.builder("s").required(false).hasArg().argName("strategy").build();
					s.setDescription("Game strategy.\nValid value are: R=Random, P=Preload (Default: Random)");
					Option h = Option.builder("h").required(false).hasArg(false).desc("Print this help").build();

					options = new Options();
					options.addOption(i);
					options.addOption(o);
					options.addOption(s);
					options.addOption(h);
				}
			}
		}
		return options;
	}

	private static void help(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(80,"java -jar tennis-jar-with-dependencies.jar",header,options,footer,true);
	}

	private void execute(String pv1, String pv2, String sv) {
		Rally r = sv.equals(STATEGY_RANDOM) ? new RandomRally() : new PreloadRally("121121");
		Game.create(new Single(pv1),new Single(pv2),r).play();
	}

	public void run(String[] args) throws ParseException, IOException {

		InputStream is = getClass().getResourceAsStream("/banner.txt");
		String banner = BannerUtils.copyToString(is);
		System.out.println();
		System.out.println(AnsiOutput.toString(AnsiElement.GREEN,banner));
		System.out.println();

		for(String arg : args) {
			if(arg.equals("-h")) {
				System.out.println();
				help(options());
				return;
			}
		}

		CommandLine cmd = new DefaultParser().parse(options(),args);
		if(cmd.hasOption("h")) {
			System.out.println();
			help(options());
			return;
		}

		String sv = STATEGY_RANDOM;

		if(cmd.hasOption("s")) {
			sv = cmd.getOptionValue("s");
			if(!sv.equals(STATEGY_RANDOM) && !sv.equals(STATEGY_PRELOAD)) {
				System.out.format("Error!!! Option [-s] accept only these values: (%1s,%2s). Try again.%n",STATEGY_RANDOM,
						STATEGY_PRELOAD);
				help(options());
				return;
			}
		}

		String pv1 = cmd.getOptionValue("p1");
		String pv2 = cmd.getOptionValue("p2");
		execute(pv1,pv2,sv);
	}

	public static void main(String[] args) {
		try {
			TennisClient client = new TennisClient();
			client.run(args);
			System.exit(0);
		}
		catch(Exception ex) {
			System.out.println();
			System.out.println(ex.getMessage());
			help(options());
			System.out.println();
			ex.printStackTrace();
			System.exit(-1);
		}
	}
}
