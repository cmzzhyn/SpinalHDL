/*                                                                           *\
**        _____ ____  _____   _____    __                                    **
**       / ___// __ \/  _/ | / /   |  / /   HDL Core                         **
**       \__ \/ /_/ // //  |/ / /| | / /    (c) Dolu, All rights reserved    **
**      ___/ / ____// // /|  / ___ |/ /___                                   **
**     /____/_/   /___/_/ |_/_/  |_/_____/                                   **
**                                                                           **
**      This library is free software; you can redistribute it and/or        **
**    modify it under the terms of the GNU Lesser General Public             **
**    License as published by the Free Software Foundation; either           **
**    version 3.0 of the License, or (at your option) any later version.     **
**                                                                           **
**      This library is distributed in the hope that it will be useful,      **
**    but WITHOUT ANY WARRANTY; without even the implied warranty of         **
**    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU      **
**    Lesser General Public License for more details.                        **
**                                                                           **
**      You should have received a copy of the GNU Lesser General Public     **
**    License along with this library.                                       **
\*                                                                           */
package spinal.core.internals

import java.text.SimpleDateFormat
import java.util.Calendar

import spinal.core._


trait MemBitsMaskKind
object MULTIPLE_RAM extends MemBitsMaskKind
object SINGLE_RAM   extends MemBitsMaskKind


object VhdlVerilogBase{

  /** Header of the RTL generated */
  def getHeader(commentSymbol: String, header: String, toplevel: Component): String =
    s"""$commentSymbol Generator : SpinalHDL v${Spinal.version}    git head : ${spinal.core.Info.gitHash}
       |$commentSymbol Date      : ${new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss").format(Calendar.getInstance().getTime)}
       |$commentSymbol Component : ${toplevel.definitionName}
       |${if(header != null) header.split("\n").map(line => s"$commentSymbol $line").mkString("\n") + "\n" else ""}
       |""".stripMargin
}


trait VhdlVerilogBase{}
