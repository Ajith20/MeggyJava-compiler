package parse;
import java_cup.runtime.Symbol;
import parse.TokenValue;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NOT_ACCEPT,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NOT_ACCEPT,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NOT_ACCEPT,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NOT_ACCEPT,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NOT_ACCEPT,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NOT_ACCEPT,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NOT_ACCEPT,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"40:9,48,46,40,48,47,40:18,48,40,39,49,40:4,31,32,51,33,1,29,30,50,37,36:7,2" +
"5,36,44,49,40,2,40:2,45,38:6,43,7,43:3,6,43:3,5,43,41,4,43:4,42:3,40:4,3,40" +
",24,14,13,23,16,38,26,11,22,27,43,18,21,20,12,8,17,15,10,19,9,28,43,34,35,4" +
"2,40:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,153,
"0,1:3,2,3,1,4,1:3,5,6,7,1,8,1,5,9,10,5:2,1,11,5:23,12,5:9,1,13,5:4,13:2,14," +
"15,16,17,1,18,19,12,20,11,21,6,22,23,24,25,26,27,28,29,30,31,19,5,32,33,34," +
"35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,13,56,57,58," +
"59,60,61,62,63,64,65,5,17,66,67,68,69,70,71,72,73,74,75,76,56,77,78,79,80,8" +
"1,82,83,84,85,86,87,88,89,90,91")[0];

	private int yy_nxt[][] = unpackFromString(92,52,
"1,2,3,4,124:4,128,124,130,132,66,73,134,77,136,124,80,138,140,142,82,124,14" +
"4,5,84,146,124,6,7,8,9,10,11:2,5,67,124,12,69,125,11,124,69,74,13,70,14,15," +
"78,69,-1:55,86,88:25,-1:5,88:5,-1:2,88:3,16,-1:32,5,-1:10,5:2,-1:17,124:16," +
"149,124:5,-1,152,124:2,-1,65,-1:3,124:2,-1:2,124,-1:2,124:3,-1:11,88:26,-1:" +
"5,88:5,-1:2,88:3,16,-1:8,76:38,22,76:12,-1:46,13,-1:6,15:45,-1:2,15:4,-1:3," +
"88:10,29,88:15,-1:5,88:5,-1:2,88:3,16,-1:10,88:7,37,88:11,38,39,88:5,-1:5,8" +
"8:5,-1:2,88:3,16,-1:11,23:21,-1,23:3,-1:5,23:2,-1:2,23,-1:2,23:3,-1:21,47:2" +
",-1,47,-1:6,47:3,-1:10,47:3,-1:16,58,114:25,-1:5,114:5,-1:2,114:3,16,-1:10," +
"124:22,-1,124:3,-1,65,-1:3,124:2,-1:2,124,-1:2,124:3,-1:11,88:12,17,88:13,-" +
"1:5,88:5,-1:2,88:3,16,-1:41,72,-1:20,88:22,68,88:3,-1:5,88:2,68:2,88,-1:2,8" +
"8:3,16,-1:53,13,75,-1:7,71,85:25,-1:5,85:5,-1:2,85:3,-1:11,88:5,18,88:15,12" +
"9,88:4,-1:5,88:5,-1:2,88:3,16,-1:54,75,-1:7,88:9,94,88:3,95,88:8,68,88,133," +
"88,-1:5,88:2,68:2,88,-1:2,88:3,16,-1:58,79,-1,79:50,83,-1:3,88:7,97,88,98,8" +
"8:10,19,88:5,-1:5,88:5,-1:2,88:3,16,-1:10,85:22,-1,85:3,-1,81,-1:3,85:2,-1:" +
"2,85,-1:2,85:3,-1:11,88:10,148,88:6,20,88:8,-1:5,88:5,-1:2,88:3,16,-1:8,79:" +
"49,57,83,-1:3,88:7,21,88:18,-1:5,88:5,-1:2,88:3,16,-1:10,87,85:25,-1:5,85:5" +
",-1:2,85:3,-1:11,137,139,137:20,88,137:3,-1,81,-1:3,137:2,88:2,137,-1:2,137" +
":3,16,-1:10,88:5,24,88:20,-1:5,88:5,-1:2,88:3,16,-1:10,88:11,25,88:14,-1:5," +
"88:5,-1:2,88:3,16,-1:10,88:10,26,88:15,-1:5,88:5,-1:2,88:3,16,-1:10,88:20,2" +
"7,88:5,-1:5,88:5,-1:2,88:3,16,-1:10,88:22,28,88:3,-1:5,88:5,-1:2,88:3,16,-1" +
":10,88:12,30,88:2,31,88:10,-1:5,88:5,-1:2,88:3,16,-1:10,88:16,32,88:9,-1:5," +
"88:5,-1:2,88:3,16,-1:10,88:12,33,88:13,-1:5,88:5,-1:2,88:3,16,-1:10,88:12,3" +
"4,88:2,35,88:10,-1:5,88:5,-1:2,88:3,16,-1:10,88:22,36,88:3,-1:5,88:5,-1:2,8" +
"8:3,16,-1:10,88:16,40,88:9,-1:5,88:5,-1:2,88:3,16,-1:10,88:23,41,88:2,-1:5," +
"88:5,-1:2,88:3,16,-1:10,88:25,42,-1:5,88:5,-1:2,88:3,16,-1:10,88:20,43,88:5" +
",-1:5,88:5,-1:2,88:3,16,-1:10,88:10,44,88:9,45,88:5,-1:5,88:5,-1:2,88:3,16," +
"-1:10,88:5,46,88:20,-1:5,88:5,-1:2,88:3,16,-1:10,88:8,48,88:17,-1:5,88:5,-1" +
":2,88:3,16,-1:10,88:15,49,88:10,-1:5,88:5,-1:2,88:3,16,-1:10,88:14,50,88:11" +
",-1:5,88:5,-1:2,88:3,16,-1:10,88:9,51,88:6,52,88:9,-1:5,88:5,-1:2,88:3,16,-" +
"1:10,88:13,53,88:12,-1:5,88:5,-1:2,88:3,16,-1:10,88:19,54,88:6,-1:5,88:5,-1" +
":2,88:3,16,-1:10,88:5,55,88:20,-1:5,88:5,-1:2,88:3,16,-1:10,88:7,56,88:18,-" +
"1:5,88:5,-1:2,88:3,16,-1:10,113,114:25,-1:5,114:5,-1:2,114:3,16,-1:10,119,1" +
"14:25,-1:5,114:5,-1:2,114:3,16,-1:10,88:15,59,88:10,-1:5,88:5,-1:2,88:3,16," +
"-1:10,88:16,60,88:9,-1:5,88:5,-1:2,88:3,16,-1:10,88:13,61,88:12,-1:5,88:5,-" +
"1:2,88:3,16,-1:10,58,114:2,120,127,114:21,-1:5,114:5,-1:2,114:3,16,-1:10,12" +
"2,114:25,-1:5,114:5,-1:2,114:3,16,-1:10,88:15,62,88:10,-1:5,88:5,-1:2,88:3," +
"16,-1:10,63,114:25,-1:5,114:5,-1:2,114:3,16,-1:10,64,114:25,-1:5,114:5,-1:2" +
",114:3,16,-1:10,88:7,105,88:18,-1:5,88:5,-1:2,88:3,16,-1:10,123,114:25,-1:5" +
",114:5,-1:2,114:3,16,-1:10,88:6,126,88:2,89,88:16,-1:5,88:5,-1:2,88:3,16,-1" +
":10,88:15,106,88:10,-1:5,88:5,-1:2,88:3,16,-1:10,88:6,90,88:4,91,88:4,92,88" +
":9,-1:5,88:5,-1:2,88:3,16,-1:10,88:13,107,88,108,88,109,110,88:7,-1:5,88:5," +
"-1:2,88:3,16,-1:10,88:19,93,88:6,-1:5,88:5,-1:2,88:3,16,-1:10,88:18,111,88:" +
"7,-1:5,88:5,-1:2,88:3,16,-1:10,88:12,131,88:13,-1:5,88:5,-1:2,88:3,16,-1:10" +
",88:15,112,88:10,-1:5,88:5,-1:2,88:3,16,-1:10,88:9,96,88:16,-1:5,88:5,-1:2," +
"88:3,16,-1:10,88:7,99,88:18,-1:5,88:5,-1:2,88:3,16,-1:10,113,114,115,114:23" +
",-1:5,114:5,-1:2,114:3,16,-1:10,88:13,100,88:12,-1:5,88:5,-1:2,88:3,16,-1:1" +
"0,88:15,116,88:10,-1:5,88:5,-1:2,88:3,16,-1:10,88:6,135,88:2,101,88:16,-1:5" +
",88:5,-1:2,88:3,16,-1:10,88:26,-1:5,117,88:4,-1:2,88:3,16,-1:10,88:17,102,8" +
"8:2,103,88:5,-1:5,88:5,-1:2,88:3,16,-1:10,88:5,118,88:20,-1:5,88:5,-1:2,88:" +
"3,16,-1:10,88:18,104,88:7,-1:5,88:5,-1:2,88:3,16,-1:10,88:21,121,88:4,-1:5," +
"88:5,-1:2,88:3,16,-1:10,88:21,141,88:4,-1:5,88:5,-1:2,88:3,16,-1:10,88:13,1" +
"43,88:12,-1:5,88,145,88:3,-1:2,88:3,16,-1:10,88:11,147,88:14,-1:5,88:5,-1:2" +
",88:3,16,-1:10,88:9,150,88:16,-1:5,88:5,-1:2,88:3,16,-1:10,88:15,151,88:10," +
"-1:5,88:5,-1:2,88:3,16,-1:7");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return new Symbol(sym.EOF);
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return new Symbol(sym.COMMA, new TokenValue(",", yyline, yychar)); }
					case -3:
						break;
					case 3:
						{ return new Symbol(sym.ASSIGN, new TokenValue("=", yyline, yychar)); }
					case -4:
						break;
					case 4:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -5:
						break;
					case 5:
						{ return new Symbol(sym.NUM, new TokenValue(yytext(), yyline, yychar)); }
					case -6:
						break;
					case 6:
						{ return new Symbol(sym.MINUS, new TokenValue("-",yyline,yychar)); }
					case -7:
						break;
					case 7:
						{ return new Symbol(sym.DOT, new TokenValue(".",yyline,yychar)); }
					case -8:
						break;
					case 8:
						{ return new Symbol(sym.LPAREN, new TokenValue("(.",yyline,yychar)); }
					case -9:
						break;
					case 9:
						{ return new Symbol(sym.RPAREN, new TokenValue(")",yyline,yychar)); }
					case -10:
						break;
					case 10:
						{ return new Symbol(sym.PLUS, new TokenValue(")",yyline,yychar)); }
					case -11:
						break;
					case 11:
						{ return new Symbol(sym.REG, new TokenValue(yytext(), yyline, yychar)); }
					case -12:
						break;
					case 12:
						{ System.out.println("Unexpected token '" + yytext() + "' on line: " + yyline + " at char: " + yychar); }
					case -13:
						break;
					case 13:
						{ yychar = 0; return new Symbol(sym.EOL); }
					case -14:
						break;
					case 14:
						{}
					case -15:
						break;
					case 15:
						{ yychar = 0; yy_buffer_start = yy_buffer_index-1; return new Symbol(sym.EOL);}
					case -16:
						break;
					case 16:
						{ return new Symbol(sym.LABEL, new TokenValue(yytext(), yyline, yychar)); }
					case -17:
						break;
					case 17:
						{ return new Symbol(sym.AVR_OR, new TokenValue("or", yyline, yychar)); }
					case -18:
						break;
					case 18:
						{ return new Symbol(sym.AVR_CP, new TokenValue("cp", yyline, yychar)); }
					case -19:
						break;
					case 19:
						{ return new Symbol(sym.AVR_LD, new TokenValue("ld", yyline, yychar));  }
					case -20:
						break;
					case 20:
						{ return new Symbol(sym.AVR_IN, new TokenValue("in", yyline, yychar)); }
					case -21:
						break;
					case 21:
						{ return new Symbol(sym.AVR_GS, new TokenValue("gs", yyline, yychar)); }
					case -22:
						break;
					case 22:
						{ return new Symbol(sym.QSTRING, new TokenValue(yytext(), yyline, yychar)); }
					case -23:
						break;
					case 23:
						{ return new Symbol(sym.TYPE, new TokenValue(yytext(), yyline, yychar)); }
					case -24:
						break;
					case 24:
						{ return new Symbol(sym.AVR_POP, new TokenValue("pop", yyline, yychar)); }
					case -25:
						break;
					case 25:
						{ return new Symbol(sym.AVR_SUB, new TokenValue("sub", yyline, yychar)); }
					case -26:
						break;
					case 26:
						{ return new Symbol(sym.AVR_SBC, new TokenValue("sbc", yyline, yychar)); }
					case -27:
						break;
					case 27:
						{ return new Symbol(sym.AVR_STD, new TokenValue("std", yyline, yychar)); }
					case -28:
						break;
					case 28:
						{ return new Symbol(sym.AVR_HI, new TokenValue("hi8", yyline, yychar)); }
					case -29:
						break;
					case 29:
						{ return new Symbol(sym.AVR_CPC, new TokenValue("cpc", yyline, yychar)); }
					case -30:
						break;
					case 30:
						{ return new Symbol(sym.AVR_ROR, new TokenValue("ror", yyline, yychar)); }
					case -31:
						break;
					case 31:
						{ return new Symbol(sym.AVR_ROL, new TokenValue("rol", yyline, yychar)); }
					case -32:
						break;
					case 32:
						{ return new Symbol(sym.AVR_RET, new TokenValue("ret", yyline, yychar)); }
					case -33:
						break;
					case 33:
						{ return new Symbol(sym.AVR_EOR, new TokenValue("eor", yyline, yychar)); }
					case -34:
						break;
					case 34:
						{ return new Symbol(sym.AVR_LSR, new TokenValue("lsr", yyline, yychar)); }
					case -35:
						break;
					case 35:
						{ return new Symbol(sym.AVR_LSL, new TokenValue("lsl", yyline, yychar)); }
					case -36:
						break;
					case 36:
						{ return new Symbol(sym.AVR_LO, new TokenValue("lo8", yyline, yychar)); }
					case -37:
						break;
					case 37:
						{ return new Symbol(sym.AVR_LDS, new TokenValue("lds", yyline, yychar)); }
					case -38:
						break;
					case 38:
						{ return new Symbol(sym.AVR_LDI, new TokenValue("ldi", yyline, yychar)); }
					case -39:
						break;
					case 39:
						{ return new Symbol(sym.AVR_LDD, new TokenValue("ldd", yyline, yychar));  }
					case -40:
						break;
					case 40:
						{ return new Symbol(sym.AVR_TST, new TokenValue("txt", yyline, yychar)); }
					case -41:
						break;
					case 41:
						{ return new Symbol(sym.AVR_NEG, new TokenValue("neg", yyline, yychar)); }
					case -42:
						break;
					case 42:
						{ return new Symbol(sym.AVR_MOV, new TokenValue("mov", yyline, yychar)); }
					case -43:
						break;
					case 43:
						{ return new Symbol(sym.AVR_AND, new TokenValue("and", yyline, yychar)); }
					case -44:
						break;
					case 44:
						{ return new Symbol(sym.AVR_ADC, new TokenValue("adc", yyline, yychar)); }
					case -45:
						break;
					case 45:
						{ return new Symbol(sym.AVR_ADD, new TokenValue("add", yyline, yychar)); }
					case -46:
						break;
					case 46:
						{ return new Symbol(sym.AVR_JMP, new TokenValue("jmp", yyline, yychar)); }
					case -47:
						break;
					case 47:
						{ return new Symbol(sym.HEX, new TokenValue(yytext(), yyline, yychar)); }
					case -48:
						break;
					case 48:
						{ return new Symbol(sym.AVR_PUSH, new TokenValue("push", yyline, yychar)); }
					case -49:
						break;
					case 49:
						{ return new Symbol(sym.AVR_CALL, new TokenValue("call", yyline, yychar)); }
					case -50:
						break;
					case 50:
						{ return new Symbol(sym.AVR_BREQ, new TokenValue("breq", yyline, yychar)); }
					case -51:
						break;
					case 51:
						{ return new Symbol(sym.AVR_BRLO, new TokenValue("brlo", yyline, yychar)); }
					case -52:
						break;
					case 52:
						{ return new Symbol(sym.AVR_BRLT, new TokenValue("brlt", yyline, yychar)); }
					case -53:
						break;
					case 53:
						{ return new Symbol(sym.AVR_BRNE, new TokenValue("brne", yyline, yychar)); }
					case -54:
						break;
					case 54:
						{ return new Symbol(sym.AVR_BRMI, new TokenValue("brne", yyline, yychar)); }
					case -55:
						break;
					case 55:
						{ return new Symbol(sym.AVR_JMP, new TokenValue("rjmp", yyline, yychar)); }
					case -56:
						break;
					case 56:
						{ return new Symbol(sym.AVR_MULS, new TokenValue("muls", yyline, yychar)); }
					case -57:
						break;
					case 57:
						{ yychar = 0; return new Symbol(sym.EOL); }
					case -58:
						break;
					case 58:
						{ return new Symbol(sym.GLOBAL, new TokenValue(yytext(), yyline, yychar)); }
					case -59:
						break;
					case 59:
						{ return new Symbol(sym.AVR_ICALL, new TokenValue("icall", yyline, yychar)); }
					case -60:
						break;
					case 60:
						{ return new Symbol(sym.DOTTEXT, new TokenValue(yytext(), yyline, yychar)); }
					case -61:
						break;
					case 61:
						{ return new Symbol(sym.DOTTYPE, new TokenValue(yytext(), yyline, yychar)); }
					case -62:
						break;
					case 62:
						{ return new Symbol(sym.DOTGLOBAL, new TokenValue(yytext(), yyline, yychar)); }
					case -63:
						break;
					case 63:
						{ return new Symbol(sym.SP_L, new TokenValue("__SP_L__", yyline, yychar)); }
					case -64:
						break;
					case 64:
						{ return new Symbol(sym.SP_H, new TokenValue("__SP_H__", yyline, yychar)); }
					case -65:
						break;
					case 66:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -66:
						break;
					case 67:
						{ return new Symbol(sym.NUM, new TokenValue(yytext(), yyline, yychar)); }
					case -67:
						break;
					case 68:
						{ return new Symbol(sym.REG, new TokenValue(yytext(), yyline, yychar)); }
					case -68:
						break;
					case 69:
						{ System.out.println("Unexpected token '" + yytext() + "' on line: " + yyline + " at char: " + yychar); }
					case -69:
						break;
					case 70:
						{ yychar = 0; return new Symbol(sym.EOL); }
					case -70:
						break;
					case 71:
						{ return new Symbol(sym.GLOBAL, new TokenValue(yytext(), yyline, yychar)); }
					case -71:
						break;
					case 73:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -72:
						break;
					case 74:
						{ System.out.println("Unexpected token '" + yytext() + "' on line: " + yyline + " at char: " + yychar); }
					case -73:
						break;
					case 75:
						{ yychar = 0; return new Symbol(sym.EOL); }
					case -74:
						break;
					case 77:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -75:
						break;
					case 78:
						{ System.out.println("Unexpected token '" + yytext() + "' on line: " + yyline + " at char: " + yychar); }
					case -76:
						break;
					case 80:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -77:
						break;
					case 82:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -78:
						break;
					case 84:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -79:
						break;
					case 86:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -80:
						break;
					case 88:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -81:
						break;
					case 89:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -82:
						break;
					case 90:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -83:
						break;
					case 91:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -84:
						break;
					case 92:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -85:
						break;
					case 93:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -86:
						break;
					case 94:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -87:
						break;
					case 95:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -88:
						break;
					case 96:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -89:
						break;
					case 97:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -90:
						break;
					case 98:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -91:
						break;
					case 99:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -92:
						break;
					case 100:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -93:
						break;
					case 101:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -94:
						break;
					case 102:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -95:
						break;
					case 103:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -96:
						break;
					case 104:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -97:
						break;
					case 105:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -98:
						break;
					case 106:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -99:
						break;
					case 107:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -100:
						break;
					case 108:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -101:
						break;
					case 109:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -102:
						break;
					case 110:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -103:
						break;
					case 111:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -104:
						break;
					case 112:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -105:
						break;
					case 113:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -106:
						break;
					case 114:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -107:
						break;
					case 115:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -108:
						break;
					case 116:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -109:
						break;
					case 117:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -110:
						break;
					case 118:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -111:
						break;
					case 119:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -112:
						break;
					case 120:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -113:
						break;
					case 121:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -114:
						break;
					case 122:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -115:
						break;
					case 123:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -116:
						break;
					case 124:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -117:
						break;
					case 125:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -118:
						break;
					case 126:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -119:
						break;
					case 127:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -120:
						break;
					case 128:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -121:
						break;
					case 129:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -122:
						break;
					case 130:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -123:
						break;
					case 131:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -124:
						break;
					case 132:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -125:
						break;
					case 133:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -126:
						break;
					case 134:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -127:
						break;
					case 135:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -128:
						break;
					case 136:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -129:
						break;
					case 137:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -130:
						break;
					case 138:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -131:
						break;
					case 139:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -132:
						break;
					case 140:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -133:
						break;
					case 141:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -134:
						break;
					case 142:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -135:
						break;
					case 143:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -136:
						break;
					case 144:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -137:
						break;
					case 145:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -138:
						break;
					case 146:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -139:
						break;
					case 147:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -140:
						break;
					case 148:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -141:
						break;
					case 149:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -142:
						break;
					case 150:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -143:
						break;
					case 151:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -144:
						break;
					case 152:
						{ return new Symbol(sym.ID, new TokenValue(yytext(), yyline, yychar)); }
					case -145:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
