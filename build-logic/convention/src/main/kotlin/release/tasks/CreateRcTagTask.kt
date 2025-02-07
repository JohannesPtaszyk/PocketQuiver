package release.tasks

import org.gradle.api.tasks.TaskAction
import release.util.RC_TAG_BUID_NUMBER_SEPERATOR
import release.util.RC_TAG_PREFIX
import release.util.execToString
import release.util.getRcTags
import release.util.getVersionNameFromBranchName

abstract class CreateRcTagTask : AbstractTagTask() {

    @TaskAction
    fun createRcTag() {
        val versionFromBranch = execOperations.getVersionNameFromBranchName()
        val latestTag = execOperations.getRcTags()
            .filter { it.contains(versionFromBranch) }
            .maxOfOrNull { it }
        val newTag = if (latestTag != null) {
            val (tag, buildNumber) = latestTag.split(RC_TAG_BUID_NUMBER_SEPERATOR)
            "$tag$RC_TAG_BUID_NUMBER_SEPERATOR${(buildNumber.toInt() + 1)}"
        } else {
            "$RC_TAG_PREFIX$versionFromBranch${RC_TAG_BUID_NUMBER_SEPERATOR}1"
        }
        execOperations.execToString("git", "tag", newTag)
        pushTag(newTag)
    }

    companion object {
        const val NAME = "createRcTag"
    }
}
