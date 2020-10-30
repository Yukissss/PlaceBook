package com.raywenderlich.placebook.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\"\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010\'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/raywenderlich/placebook/ui/BookmarkDetailsActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/raywenderlich/placebook/ui/PhotoOptionDialogFragment$PhotoOptionDialogListener;", "()V", "bookmarkDetailsView", "Lcom/raywenderlich/placebook/viewmodel/BookmarkDetailsViewModel$BookmarkDetailsView;", "bookmarkDetailsViewModel", "Lcom/raywenderlich/placebook/viewmodel/BookmarkDetailsViewModel;", "photoFile", "Ljava/io/File;", "deleteBookmark", "", "getImageWithAuthority", "Landroid/graphics/Bitmap;", "uri", "Landroid/net/Uri;", "getImageWithPath", "filePath", "", "getIntentData", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCaptureClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPickClick", "populateCategoryList", "populateFields", "populateImageView", "replaceImage", "saveChanges", "setupFab", "setupToolbar", "setupViewModel", "sharePlace", "updateImage", "image", "Companion", "app_debug"})
public final class BookmarkDetailsActivity extends android.support.v7.app.AppCompatActivity implements com.raywenderlich.placebook.ui.PhotoOptionDialogFragment.PhotoOptionDialogListener {
    private com.raywenderlich.placebook.viewmodel.BookmarkDetailsViewModel bookmarkDetailsViewModel;
    private com.raywenderlich.placebook.viewmodel.BookmarkDetailsViewModel.BookmarkDetailsView bookmarkDetailsView;
    private java.io.File photoFile;
    private static final int REQUEST_CAPTURE_IMAGE = 1;
    private static final int REQUEST_GALLERY_IMAGE = 2;
    public static final com.raywenderlich.placebook.ui.BookmarkDetailsActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCaptureClick() {
    }
    
    @java.lang.Override()
    public void onPickClick() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final android.graphics.Bitmap getImageWithAuthority(android.net.Uri uri) {
        return null;
    }
    
    private final void updateImage(android.graphics.Bitmap image) {
    }
    
    private final android.graphics.Bitmap getImageWithPath(java.lang.String filePath) {
        return null;
    }
    
    private final void replaceImage() {
    }
    
    private final void deleteBookmark() {
    }
    
    private final void saveChanges() {
    }
    
    private final void getIntentData() {
    }
    
    private final void setupViewModel() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void sharePlace() {
    }
    
    private final void setupFab() {
    }
    
    private final void populateFields() {
    }
    
    private final void populateImageView() {
    }
    
    private final void populateCategoryList() {
    }
    
    public BookmarkDetailsActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/raywenderlich/placebook/ui/BookmarkDetailsActivity$Companion;", "", "()V", "REQUEST_CAPTURE_IMAGE", "", "REQUEST_GALLERY_IMAGE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}