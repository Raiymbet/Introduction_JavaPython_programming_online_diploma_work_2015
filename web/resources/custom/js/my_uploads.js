/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Define some variables used to remember state.
var playlistId, nextPageToken, prevPageToken, playlist_videos=[];

var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);                        
var player;

function onYouTubeIframeAPIReady(){
    player = new YT.Player('video-container',{
        height: '80%',
        width: '100%',
        playerVars: {
            color: 'white'
        }
    });
}
// After the API loads, call a function to get the uploads playlist ID.
function handleAPILoaded() {
    requestUserUploadsPlaylistId();
    //requestUserUploadsPlayList();
}

// Call the Data API to retrieve the playlist ID that uniquely identifies the
// list of videos uploaded to the currently authenticated user's channel.
function requestUserUploadsPlaylistId() {
  // See https://developers.google.com/youtube/v3/docs/channels/list
  var request = gapi.client.youtube.channels.list({
    mine: true,
    part: 'contentDetails'
  });
  request.execute(function(response) {
    console.log(response);
    playlistId = response.result.items[0].contentDetails.relatedPlaylists.uploads;
    requestVideoPlaylist(playlistId);
    
  });
}

function requestUserUploadsPlayList(){
    var request = gapi.client.youtube.channels.list({
        mine: true,
        part: 'id'
    });
    request.execute(function (response){
        console.log(response);
    });
}

// Retrieve the list of videos in the specified playlist.
function requestVideoPlaylist(playlistId, pageToken) {
  //$('#video-container').html('');
  var requestOptions = {
    playlistId: playlistId,
    part: 'snippet',
    maxResults: 10
  };
  if (pageToken) {
    requestOptions.pageToken = pageToken;
  }
  var request = gapi.client.youtube.playlistItems.list(requestOptions);
  request.execute(function(response) {
    // Only show pagination buttons if there is a pagination token for the
    // next or previous page of results.
    nextPageToken = response.result.nextPageToken;
    var nextVis = nextPageToken ? 'visible' : 'hidden';
    $('#next-button').css('visibility', nextVis);
    prevPageToken = response.result.prevPageToken
    var prevVis = prevPageToken ? 'visible' : 'hidden';
    $('#prev-button').css('visibility', prevVis);

    var playlistItems = response.result.items;
    if (playlistItems) {
        $.each(playlistItems, function(index, item) {
            displayResult(item.snippet);
        });     
        player.loadPlaylist(playlist_videos);
        var playing_video_index = player.getPlaylistIndex();
        $('#video_url').text(player.getVideoUrl());
        $('#video_name').text(playlistItems[playing_video_index].item.snippet.title);
    } else {
      $('#playlist_video_lists').html('Sorry you have no uploaded videos');
    }
  });
}

// Create a listing for a video.
function displayResult(videoSnippet) {
    var title = videoSnippet.title;
    var videoId = videoSnippet.resourceId.videoId;  
    playlist_videos.push(videoId);
    //console.log(videoSnippet);
    var thumbnail, video_duration, video_name, video_channel,video_view_count;
    $('#playlist_video_lists').append(
        '<li class="video-list-item related-list-item">'+
            '<div class="thumb-wrapper">'+
                '<a href="">'+
                    '<img src="<c:url value="/resources/img/skorpion.jpg" />" style="height: 90px; width: 120px;">'+
                '</a>'+
                '<span class="video-time">'+
                    '2:46'+
                '</span>'+
            '</div>'+
            '<div class="content-wrapper">'+
                '<a href="">'+
                    '<h6>Video name</h6>'+
                    'Video owner <br>'+
                    'Video view count<br>'+
                '</a>'+
            '</div>'+
        '</li>');
}

// Retrieve the next page of videos in the playlist.
function nextPage() {
    playlist_videos = [];
    requestVideoPlaylist(playlistId, nextPageToken);
}

// Retrieve the previous page of videos in the playlist.
function previousPage() {
    playlist_videos = [];
    requestVideoPlaylist(playlistId, prevPageToken);
}

