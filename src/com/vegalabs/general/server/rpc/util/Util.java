package com.vegalabs.general.server.rpc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Util {
  private final Logger LOG = Logger.getLogger(Util.class.getName());

  private static final String DATE_TIME_PATTERN = "EEE, d MMM yyyy HH:mm:ss Z";
  public final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat(
      DATE_TIME_PATTERN).registerTypeAdapter(Pattern.class, new PatternSerializer()).create();

  @Inject
  public Util() {
  }

  public String toJson(Object o) {
    return GSON.toJson(o);
  }

  public Object fromJson(String json, Class clazz) {
    return GSON.fromJson(json, clazz);
  }

  private static class PatternSerializer implements JsonSerializer<Pattern>,
      JsonDeserializer<Pattern> {
    public JsonElement toJson(Pattern pattern, Type type, JsonSerializationContext context) {
      return serialize(pattern, type, context);
    }

    public Pattern fromJson(JsonElement json, Type type, JsonDeserializationContext context) {
      return deserialize(json, type, context);
    }

    public JsonElement serialize(Pattern pattern, Type type, JsonSerializationContext context) {
      return new JsonPrimitive(pattern.pattern());
    }

    public Pattern deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
      try {
        return Pattern.compile(json.getAsString(), Pattern.CASE_INSENSITIVE);
      } catch (JsonParseException e) {
        return null;
      }
    }
  }

  public String fetchUrl(String url) throws Exception {
    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder result = new StringBuilder();
    try {
      String inputLine;
      while ((inputLine = reader.readLine()) != null) {
        result.append(inputLine);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result.toString();
  }

  public boolean isNullOrEmpty(String input) {
    if (input == null || input.trim().length() <= 0) {
      return true;
    } else {
      return false;
    }
  }

  public static String getSelfUrl(HttpServletRequest request) {
    StringBuffer url = new StringBuffer();

    url.append(request.getRequestURL());
    String queryString = request.getQueryString();
    if (queryString != null && queryString.length() > 0) {
      url.append("?");
      url.append(queryString);
    }

    return url.toString();
  }

  public String getPostBody(HttpServletRequest req) throws IOException {
    InputStream is = req.getInputStream();

    StringBuffer body = new StringBuffer();
    String line = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while ((line = br.readLine()) != null) {
      body.append(line);
      body.append("\n");
    }
    return body.toString();
  }
}
