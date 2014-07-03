<script>
angular.module('home-app').service('Modal',function( $modal){
	
	this.OpenModal = function(arg, successCallback) {
		this.instance = $modal.open(arg);
		this.onSuccess = successCallback;
	};
	
	this.CloseModal = function() {
		this.instance.dismiss('close');
		this.onSuccess();
	};
	
	this.OnOpen = function (opened) {
		this.instance.opened.then(opened);
	};
	
});
</script>