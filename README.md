# The NY Times demo application

This is the NY Times demo application which can download the most popular articles.
This master/detail application demo is also optimalized for mobile and tablet.

## Getting Started

After you imported the project to Andriod Studio you can run the application.
In case the classes end with "_" do not founded, clean and build the project. (it can be caused by the AndroidAnnotations)

In the application you have to use your own api key which you need to overwrite the value of the ApiInterface API_KEY. (for this example I left my own key)

The news list (RecycleView) loads more items if the list's end is near and it downloads 20 items each fetch.
You can use pull to refresh to reload the list.

### Mobile mode:
On the first Activity you can choose an article. After the article tapped, the details of the selected article will be opened in a new Activity. 

### Table mode:
On the left side of the view there is a list (the same as in the mobile mode) and on the right side of the view there is a detail view (the same as in the mobile mode).
As you tap an article from the left list the selected article's details will appear in the right detail view.

## Used third party libraries
AndroidAnnotations
Retrofit (okHttp)
Picasso

## Known issue
The NY Times api sometimes sends back "" instead of [] as empty array.

## Version
1.0

