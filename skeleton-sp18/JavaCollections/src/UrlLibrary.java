//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Iterator;
//import java.util.LinkedList;
//
//public class UrlLibrary implements Iterable<String> {
//  private LinkedList<String> urls = new LinkedList<String>();
//
//  private class UrlIterator implements Iterator<String> {
//    private int index = 0;
//    @Override
//    public boolean hasNext() {
//      return index < urls.size();
//    }
//
//    @Override
//    public String next() {
//      try {
//        URL url = new URL(urls.get(index));
//        BufferedReader br = new BufferedReader((new InputStreamReader(url.openStream())));
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//        while((line = br.readLine()) != null) {
//          sb.append(line);
//          sb.append("\n");
//        }
//        br.close();
//      } catch (MalformedURLException e) {
//        e.printStackTrace();
//      }
//      index++;
//      return null;
//    }
//
//    @Override
//    public void remove() {
//      if urls.remove(index);
//    }
//  }
//
//  public UrlLibrary() {
//    urls.add("google.com");
//    urls.add("youtube.com");
//    urls.add("vimeo.com");
//  }
//
//  @Override
//  public Iterator<String> iterator() {
//    return null;
//  }
//
////  @Override
////  public Iterator<String> iterator() {
////    //TODO auto generated method
////    return urls.iterator();
////  }
//}
