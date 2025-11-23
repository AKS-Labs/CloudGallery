I have applied a fix to `app/src/main/java/com/akslabs/chitralaya/ui/components/DragSelectableLazyVerticalGrid.kt`.

The `onLongPress` callback now immediately sets `isDragging = true` when a long-press initiates selection. This ensures that the drag state is consistently active for long-press-initiated selections. I've also refined the logic within `detectDragGestures` to correctly handle both long-press-initiated drags and standard touch-slop-based glide selections.

Please try to build and test the application again to verify that both the "long-press and drag/glide to select multiple photos" and the existing "glide selection" functionalities are working as expected.

If you'd like me to attempt a build, you can approve the following command:
`run_shell_command(".\gradlew assembleDebug", description="Attempting to build the application")`