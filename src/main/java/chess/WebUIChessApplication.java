package chess;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import chess.controller.ChessController;
import chess.domain.board.Board;
import chess.domain.board.BoardFactory;
import chess.domain.piece.Team;
import chess.service.ChessService;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebUIChessApplication {
	public static void main(String[] args) {
		staticFiles.location("/public");

		Board initial = BoardFactory.create();
		Team first = Team.WHITE;
		ChessService chessService = ChessService.of(initial);
		ChessController controller = new ChessController(chessService, initial, first);

		Map<String, Object> model = new HashMap<>();

		get("/", (req, res) -> {
			initial.getBoard().forEach((position, piece) -> {
				model.put(position.getName(), piece.getSymbol());
			});
			return render(model, "index.html");
		});

		post("/api/move", "application/json", (req, res) -> {
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(req.body());

			String from = element.getAsJsonObject().get("from").getAsString();
			String to = element.getAsJsonObject().get("to").getAsString();

			controller.playTurn("move " + from + " " + to);
			return "ok";
		});
	}

	private static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
