/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package daniel.stanciu.dropboxnotes;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defines a contract between the Note Pad content provider and its clients. A contract defines the
 * information that a client needs to access the provider as one or more data tables. A contract
 * is a public, non-extendable (final) class that contains constants defining column names and
 * URIs. A well-written client depends only on the constants in the contract.
 */
public final class NotePad {
    public static final String AUTHORITY = "daniel.stanciu.dropboxnotes.DropboxNotes";

    // This class cannot be instantiated
    private NotePad() {
    }

    /**
     * Notes table contract
     */
    public static final class Notes implements BaseColumns {

        // This class cannot be instantiated
        private Notes() {}

        /**
         * The table name offered by this provider
         */
        public static final String TABLE_NAME = "notes";

        /*
         * URI definitions
         */

        /**
         * The scheme part for this provider's URI
         */
        private static final String SCHEME = "content://";

        /**
         * Path parts for the URIs
         */

        /**
         * Path part for the Notes URI
         */
        private static final String PATH_NOTES = "/notes";

        /**
         * Path part for the Note ID URI
         */
        private static final String PATH_NOTE_ID = "/notes/";

        /**
         * 0-relative position of a note ID segment in the path part of a note ID URI
         */
        public static final int NOTE_ID_PATH_POSITION = 1;
        
        /**
         * The content:// style URL for this table
         */
        public static final Uri CONTENT_URI =  Uri.parse(SCHEME + AUTHORITY + PATH_NOTES);

        /**
         * The content URI base for a single note. Callers must
         * append a numeric note id to this Uri to retrieve a note
         */
        public static final Uri CONTENT_ID_URI_BASE
            = Uri.parse(SCHEME + AUTHORITY + PATH_NOTE_ID);

        /**
         * The content URI match pattern for a single note, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri CONTENT_ID_URI_PATTERN
            = Uri.parse(SCHEME + AUTHORITY + PATH_NOTE_ID + "/#");

        /**
         * Path part for the Folders URI
         */
        private static final String PATH_FOLDERS = "/folders";

        /**
         * Path part for the Folder Name URI
         */
        private static final String PATH_FOLDER_NAME = "/folders/";

        /**
         * 0-relative position of a folder name segment in the path part of a folder name URI
         */
        public static final int FOLDER_NAME_PATH_POSITION = 1;
        
        /**
         * The content:// style URL for folders view
         */
        public static final Uri FOLDERS_URI = Uri.parse(SCHEME + AUTHORITY + PATH_FOLDERS);
        
        /**
         * The content URI base for a single folder. Callers must
         * append a string folder name to this Uri to retrieve a folder
         */
        public static final Uri FOLDER_NAME_URI_BASE
            = Uri.parse(SCHEME + AUTHORITY + PATH_FOLDER_NAME);

        /**
         * The content URI match pattern for a single note, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri FOLDER_NAME_URI_PATTERN
            = Uri.parse(SCHEME + AUTHORITY + PATH_FOLDER_NAME + "/*");

        /*
         * MIME type definitions
         */

        /**
         * The MIME type of {@link #CONTENT_URI} or {@link #FOLDER_NAME_URI_PATTERN} providing a directory of notes.
         */
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.daniel.stanciu.dropboxnotes";

        /**
         * The MIME type of a {@link #CONTENT_URI} sub-directory of a single
         * note.
         */
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.daniel.stanciu.dropboxnotes";

        /**
         * The MIME type of a {@link #CONTENT_FOLDERS_TYPE} providing a list of folders.
         */
		public static final String CONTENT_FOLDERS_TYPE = "vnd.android.cursor.dir/vnd.daniel.stanciu.dropboxnotes.folders";

		/**
         * The default sort order for this table
         */
        public static final String DEFAULT_SORT_ORDER = "modified DESC";

        /*
         * Column definitions
         */

        /**
         * Column name for the title of the note
         * <P>Type: TEXT</P>
         */
        public static final String COLUMN_NAME_TITLE = "title";

        /**
         * Column name of the note content
         * <P>Type: TEXT</P>
         */
        public static final String COLUMN_NAME_NOTE = "note";

        /**
         * Column name for the creation timestamp
         * <P>Type: INTEGER (long from System.curentTimeMillis())</P>
         */
        public static final String COLUMN_NAME_CREATE_DATE = "created";

        /**
         * Column name for the modification timestamp
         * <P>Type: INTEGER (long from System.curentTimeMillis())</P>
         */
        public static final String COLUMN_NAME_MODIFICATION_DATE = "modified";
        
        public static final String COLUMN_NAME_DELETED = "deleted";

		public static final String COLUMN_NAME_FILE_NAME = "filename";

		public static final String COLUMN_NAME_FOLDER = "folder";
    }
}
